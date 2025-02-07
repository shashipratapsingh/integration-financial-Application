package com.IFA.service.impl;

import com.IFA.entity.UploadDocs;
import com.IFA.repository.DocsRepository;
import com.IFA.service.DocsService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DocsServiceImpl implements DocsService {

    @Autowired
    private DocsRepository docsRepository;

    @Value("${file.upload-dir}") // From application.properties
    private String uploadDir;

    public UploadDocs saveUploadDocs(UploadDocs uploadDocs, MultipartFile docsFileFile) throws IOException {

        // Generate a unique filename
        String fileName = docsFileFile.getOriginalFilename();

        // Ensure the directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Define the path where the file will be saved
        File filePath = new File(uploadDir + "/" + fileName);

        // Save the file to the specified location
        docsFileFile.transferTo(filePath);

        // Set the file name and URL in the candidateDetails entity
        uploadDocs.setDocsCardFileName(fileName);
        uploadDocs.setDocsFilePath("/documents/" + fileName);  // Assuming the images are served from this path
        return docsRepository.save(uploadDocs);
    }

    @Override
    public UploadDocs getUploadDocsById(int id) {
        Optional<UploadDocs> uploadDocsOptional = docsRepository.findById(id);
        return uploadDocsOptional.orElse(null); // Return null if not found
    }

    @Override
    public List<UploadDocs> getUploadDocsAll() {
        return docsRepository.findAll(); // No need for Optional here
    }

    @Override
    public byte[] generatePdfById(int id) {
        Optional<UploadDocs> uploadDocsOptional = docsRepository.findById(id);
        if (uploadDocsOptional.isEmpty()) {
            throw new RuntimeException("Document not found with ID: " + id);
        }

        UploadDocs uploadDocs = uploadDocsOptional.get();

        try (PDDocument document = new PDDocument();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.newLineAtOffset(50, 750);

            // Add content to the PDF
            contentStream.showText("Document Details:");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("ID: " + uploadDocs.getId());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Name: " + uploadDocs.getDocumentsName());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Description: " + uploadDocs.getDescriptions());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Created By: " + uploadDocs.getCreatedBy());
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Updated By: " + uploadDocs.getUpdatedBy());

            contentStream.endText();
            contentStream.close();

            document.save(out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error generating PDF: " + e.getMessage());
        }
    }

    @Override
    public List<UploadDocs> findByStatus(String status) {
        return docsRepository.findByStatus(status); // Directly return the list of upload documents
    }
}

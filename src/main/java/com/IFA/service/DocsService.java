package com.IFA.service;

import com.IFA.entity.UploadDocs;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocsService {

    UploadDocs saveUploadDocs(UploadDocs uploadDocs, MultipartFile docsFileFile) throws IOException;
    UploadDocs getUploadDocsById(int id);
    List<UploadDocs> getUploadDocsAll();
    byte[] generatePdfById(int id); // New method to generate PDF
    List<UploadDocs> findByStatus(String status);
}

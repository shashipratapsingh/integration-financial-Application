package com.IFA.controller;

import com.IFA.entity.UploadDocs;
import com.IFA.service.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PreAuthorize("hasAuthority('ROLE_Admin')")
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Admin Dashboard";
    }
    @Autowired
    private DocsService docsService;


    @PreAuthorize("hasAnyAuthority('ROLE_Admin')")
    @PostMapping("/")
    public ResponseEntity<UploadDocs> createCandidateDetails(
            @RequestPart("uploadDocs") UploadDocs uploadDocs,
            @RequestPart("docsFileFile") MultipartFile docsFileFile) throws IOException {
        UploadDocs savedCandidateDetails = docsService.saveUploadDocs(uploadDocs, docsFileFile);
        return ResponseEntity.ok(savedCandidateDetails);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    public ResponseEntity<UploadDocs> getUploadDocsById(@PathVariable("id") int id) {
        UploadDocs candidateDetails = docsService.getUploadDocsById(id);
        if (candidateDetails != null) {
            return ResponseEntity.ok(candidateDetails);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if candidate not found
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    public ResponseEntity<List<UploadDocs>> getUploadDocsAll() {
        List<UploadDocs> uploadDocsDetails = docsService.getUploadDocsAll();
        if (uploadDocsDetails != null && !uploadDocsDetails.isEmpty()) {
            return ResponseEntity.ok(uploadDocsDetails); // Return the list directly
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if no documents are found
        }
    }


    @GetMapping("/generate-pdf/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    public ResponseEntity<byte[]> generatePdf(@PathVariable("id") int id) {
        try {
            byte[] pdfBytes = docsService.generatePdfById(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document_" + id + ".pdf");
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.add("Content-Transfer-Encoding", "binary");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(pdfBytes.length)
                    .body(pdfBytes);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    public ResponseEntity<List<UploadDocs>> getUploadDocsByStatus(@PathVariable String status) {
        List<UploadDocs> statusList = docsService.findByStatus(status);
        if (statusList != null && !statusList.isEmpty()) {
            return ResponseEntity.ok(statusList); // Return the list directly
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if no documents found
        }
    }
}

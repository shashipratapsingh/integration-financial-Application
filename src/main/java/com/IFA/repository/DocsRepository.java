package com.IFA.repository;


import com.IFA.entity.UploadDocs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocsRepository extends JpaRepository<UploadDocs, Integer> {
    List<UploadDocs> findByStatus(String status); // Correct method to find by status
}


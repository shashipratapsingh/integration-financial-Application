package com.IFA.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class UploadDocs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String documentsName;
    private String descriptions;

    private String docsFilePath;
    private String docsCardFileName;
    private String status="pending";

    @Column(name = "createdBy")
    private Date createdBy;

    @Column(name = "updatedBy")
    private Date updatedBy;

    @PrePersist
    protected void onCreate() {
        createdBy = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedBy = new Date();
    }

}

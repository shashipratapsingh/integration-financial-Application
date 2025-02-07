package com.IFA.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String contactNumber;
    private String email;
    private Double loanAmount;
    private String loanType;
    private Integer loanTenure;
    private Double interestRate;
    private String purposeOfLoan;

    private String employmentType;
    private Double annualIncome;
    private String companyName;
    private Integer workExperience;

    private String applicationStatus; // Pending, Under Review, Approved, Rejected
    private Long bankManagerId;
    private Long adminId;
    private String reviewComments;
    private Date approvalDate;

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


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
    private String reviewComments;
    private Date approvalDate;
    private String kycStatus; // Pending, Verified, Rejected
    private String aadhaarNumber;
    private String panNumber;

    @ManyToOne
    @JoinColumn(name = "kyc_verified_by")
    private Users kycVerifiedBy;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Users approvedBy;

    @Column(name = "createdOn")
    private Date createdOn;

    @Column(name = "updatedOn")
    private Date updatedOn;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedOn = new Date();
    }
}
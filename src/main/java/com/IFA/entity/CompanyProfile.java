package com.IFA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company_profile")
public class CompanyProfile {

    @Id
    @Column(length = 15, unique = true, nullable = false)
    private String gstnNo; // GSTN is 15 characters long

    private String companyName;
    private String companyAddress;
    private String companyEmail;
    private String companyPhone;
    private String companyWebsite;
    private String businessType;
    private String companyLogo;
    private String companyDescription;
    private String companyIndustry;
    private String companyCountry;
    private String companyState;
    private String companyCity;
    private String companyPinCode;
    private Double balanceSheet;
}

package com.IFA.entity;

import com.IFA.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String applicationNumber;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column(unique = true, nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String pin;

    @Column(nullable = false)
    private String cvv;

    private String name;
    private String mobileNumber;
    private String fatherName;
    private String dob;
    private String gender;
    private String email;
    private String maritalStatus;
    private String address;
    private String city;
    private String pinCode;
    private String state;

    private String religion;
    private String category;
    private String income;
    private String educationalDetails;
    private String occupation;
    private String panNumber;
    private String aadhaarNumber;
    private boolean seniorCitizen;
    private boolean existingAccount;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private double balance;

    private String kycStatus;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @PrePersist
    public void generateAccountDetails() {
        this.applicationNumber = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        this.accountNumber = String.format("%016d", (long) (Math.random() * Math.pow(10, 16)));
        this.cardNumber = String.format("%016d", (long) (Math.random() * Math.pow(10, 16)));
        this.pin = String.format("%04d", (int) (Math.random() * 10000));
        this.cvv = String.format("%03d", (int) (Math.random() * 1000));
        this.balance = 0.0;
        this.kycStatus = "Pending";
    }
}

package com.IFA.service;

import com.IFA.entity.LoanApplication;

import java.util.List;

public interface LoanService {
    LoanApplication applyForLoan(LoanApplication loanApplication);
    LoanApplication getLoanApplicationById(Long id);
    LoanApplication approveLoan(Long id, Long adminId, String comments);
    List<LoanApplication> getAllLoanApplications();
    LoanApplication verifyKYC(Long id, String aadhaarNumber, String panNumber, String kycStatus);
}
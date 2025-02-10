package com.IFA.service;

import com.IFA.entity.LoanApplication;
import java.util.List;

public interface LoanService {
    LoanApplication applyForLoan(LoanApplication loanApplication);
    LoanApplication getLoanApplicationById(Long id);
    // Updated method signature: managerId is used for approval.
    LoanApplication approveLoan(Long id, Long managerId, String comments);
    List<LoanApplication> getAllLoanApplications();
    LoanApplication verifyKYC(Long id, Long managerId, String aadhaarNumber, String panNumber, String kycStatus);
}

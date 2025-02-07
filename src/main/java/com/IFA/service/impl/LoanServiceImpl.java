package com.IFA.service.impl;

import com.IFA.entity.LoanApplication;
import com.IFA.repository.LoanApplicationRepository;
import com.IFA.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanApplicationRepository loanRepository;

    @Override
    public LoanApplication applyForLoan(LoanApplication loanApplication) {
        loanApplication.setApplicationStatus("Pending");
        loanApplication.setKycStatus("Pending");
        return loanRepository.save(loanApplication);
    }

    @Override
    public LoanApplication getLoanApplicationById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    @Override
    public LoanApplication approveLoan(Long id, Long adminId, String comments) {
        Optional<LoanApplication> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isPresent()) {
            LoanApplication loan = optionalLoan.get();
            loan.setApplicationStatus("Approved");
            loan.setAdminId(adminId);
            loan.setReviewComments(comments);
            loan.setApprovalDate(new Date());
            return loanRepository.save(loan);
        }
        return null;
    }

    @Override
    public List<LoanApplication> getAllLoanApplications() {
        return loanRepository.findAll();
    }

    @Override
    public LoanApplication verifyKYC(Long id, String aadhaarNumber, String panNumber, String kycStatus) {
        Optional<LoanApplication> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isPresent()) {
            LoanApplication loan = optionalLoan.get();
            loan.setAadhaarNumber(aadhaarNumber);
            loan.setPanNumber(panNumber);
            loan.setKycStatus(kycStatus);
            return loanRepository.save(loan);
        }
        return null;
    }
}
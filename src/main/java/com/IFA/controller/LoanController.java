package com.IFA.controller;

import com.IFA.entity.LoanApplication;
import com.IFA.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public LoanApplication applyForLoan(@RequestBody LoanApplication loanApplication) {
        return loanService.applyForLoan(loanApplication);
    }

    @GetMapping("/{id}")
    public LoanApplication getLoanApplication(@PathVariable Long id) {
        return loanService.getLoanApplicationById(id);
    }

    // Updated: Only manager can approve a loan; requires that KYC has been approved.
    @PutMapping("/approve/{id}")
    public LoanApplication approveLoan(@PathVariable Long id,
                                       @RequestParam Long managerId,
                                       @RequestParam String comments) {
        return loanService.approveLoan(id, managerId, comments);
    }

    @GetMapping("/all")
    public List<LoanApplication> getAllLoanApplications() {
        return loanService.getAllLoanApplications();
    }

    @PostMapping("/kyc/verify/{id}")
    public LoanApplication verifyKYC(@PathVariable Long id,
                                     @RequestParam Long managerId,
                                     @RequestParam String aadhaarNumber,
                                     @RequestParam String panNumber,
                                     @RequestParam String kycStatus) {
        return loanService.verifyKYC(id, managerId, aadhaarNumber, panNumber, kycStatus);
    }
}

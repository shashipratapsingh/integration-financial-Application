package com.IFA.controller;

import com.IFA.entity.LoanApplication;
import com.IFA.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    public LoanApplication applyForLoan(@RequestBody LoanApplication loanApplication) {
        return loanService.applyForLoan(loanApplication);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    public LoanApplication getLoanApplication(@PathVariable Long id) {
        return loanService.getLoanApplicationById(id);
    }

    @PutMapping("/approve/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    public LoanApplication approveLoan(@PathVariable Long id, @RequestParam Long adminId, @RequestParam String comments) {
        return loanService.approveLoan(id, adminId, comments);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    public List<LoanApplication> getAllLoanApplications() {
        return loanService.getAllLoanApplications();
    }
}
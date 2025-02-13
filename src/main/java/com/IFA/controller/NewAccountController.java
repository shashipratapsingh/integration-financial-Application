package com.IFA.controller;

import com.IFA.entity.Accounts;
import com.IFA.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/newAccount")
public class NewAccountController {

    private final AccountService accountService;

    public NewAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    @PostMapping("/create")
    public ResponseEntity<Accounts> createNewAccount(@RequestBody Accounts account) {
        return ResponseEntity.ok(accountService.createNewAccount(account));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<Double> checkBalance(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.checkBalance(accountNumber));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    @PostMapping("/deposit/{accountNumber}/{amount}")
    public ResponseEntity<Accounts> deposit(@PathVariable String accountNumber, @PathVariable double amount) {
        return ResponseEntity.ok(accountService.depositAmount(accountNumber, amount));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    @PostMapping("/withdraw/{accountNumber}/{amount}")
    public ResponseEntity<Accounts> withdraw(@PathVariable String accountNumber, @PathVariable double amount) {
        return ResponseEntity.ok(accountService.withdrawAmount(accountNumber, amount));
    }
}

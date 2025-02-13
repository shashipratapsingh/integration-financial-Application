package com.IFA.service.impl;

import com.IFA.entity.Accounts;
import com.IFA.repository.AccountRepository;
import com.IFA.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Accounts createNewAccount(Accounts account) {
        return accountRepository.save(account);
    }

    public Optional<Accounts> getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public double checkBalance(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(Accounts::getBalance)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Transactional
    public Accounts depositAmount(String accountNumber, double amount) {
        Accounts account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    @Transactional
    public Accounts withdrawAmount(String accountNumber, double amount) {
        Accounts account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }
}

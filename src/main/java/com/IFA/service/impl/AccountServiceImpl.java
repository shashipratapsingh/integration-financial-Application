package com.IFA.service.impl;

import com.IFA.entity.Accounts;
import com.IFA.entity.CompanyProfile;
import com.IFA.repository.AccountRepository;
import com.IFA.repository.CompanyProfileRepository;
import com.IFA.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CompanyProfileRepository companyProfileRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CompanyProfileRepository companyProfileRepository) {
        this.accountRepository = accountRepository;
        this.companyProfileRepository = companyProfileRepository;
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

        if (!"Approved".equalsIgnoreCase(account.getKycStatus())) {
            throw new RuntimeException("KYC not approved. Transactions are not allowed.");
        }

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        updateCompanyBalance(amount, true); // True for deposit

        return account;
    }

    @Transactional
    public Accounts withdrawAmount(String accountNumber, double amount) {
        Accounts account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (!"Approved".equalsIgnoreCase(account.getKycStatus())) {
            throw new RuntimeException("KYC not approved. Transactions are not allowed.");
        }

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        updateCompanyBalance(amount, false); // False for withdrawal

        return account;
    }

    private void updateCompanyBalance(double amount, boolean isDeposit) {
        CompanyProfile companyProfile = companyProfileRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Company profile not found"));

        double updatedBalanceSheet = isDeposit ? companyProfile.getBalanceSheet() + amount
                : companyProfile.getBalanceSheet() - amount;

        companyProfile.setBalanceSheet(updatedBalanceSheet);
        companyProfileRepository.save(companyProfile);
    }

    @Override
    public Accounts verifyKyc(String accountNumber, String kycStatus) {
        Accounts account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setKycStatus(kycStatus);
        return accountRepository.save(account);
    }
}

package com.IFA.service;

import com.IFA.entity.Accounts;

import java.util.Optional;

public interface AccountService {
    Accounts createNewAccount(Accounts account);
    Optional<Accounts> getAccountByNumber(String accountNumber);
    double checkBalance(String accountNumber);
    Accounts depositAmount(String accountNumber, double amount);
    Accounts withdrawAmount(String accountNumber, double amount);
    Accounts verifyKyc(String accountNumber, String kycStatus);
}

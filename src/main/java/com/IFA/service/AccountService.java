package com.IFA.service;

import com.IFA.entity.Accounts;

import java.util.Optional;

public interface AccountService {
    public Accounts createNewAccount(Accounts account);
    public Optional<Accounts> getAccountByNumber(String accountNumber);
    public double checkBalance(String accountNumber);
    public Accounts depositAmount(String accountNumber, double amount);
    public Accounts withdrawAmount(String accountNumber, double amount);
}

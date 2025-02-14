package com.IFA.cronjobs;

import com.IFA.entity.Accounts;
import com.IFA.entity.CompanyProfile;
import com.IFA.repository.AccountRepository;
import com.IFA.repository.CompanyProfileRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SavingAccountInterest {

    private final AccountRepository accountRepository;
    private final CompanyProfileRepository companyProfileRepository;

    public SavingAccountInterest(AccountRepository accountRepository, CompanyProfileRepository companyProfileRepository) {
        this.accountRepository = accountRepository;
        this.companyProfileRepository = companyProfileRepository;
    }

    @Scheduled(cron = "0 * * * * *") // Runs every 1 minute
    @Transactional
    public void applyInterestToSavingsAccounts() {
        System.out.println("Cron job started: Checking for eligible accounts...");

        List<Accounts> eligibleAccounts = accountRepository.findEligibleAccountsForInterest(LocalDateTime.now().minusYears(1));

        if (eligibleAccounts.isEmpty()) {
            System.out.println("No eligible accounts found for interest calculation.");
            return;
        }

        CompanyProfile companyProfile = companyProfileRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Company profile not found"));

        double totalInterest = 0.0;

        for (Accounts account : eligibleAccounts) {
            double interest = account.getBalance() * 0.03; // 3% interest
            account.setBalance(account.getBalance() + interest);
            accountRepository.save(account);
            totalInterest += interest;

            System.out.println("Interest added: " + interest + " to Account: " + account.getAccountNumber());
        }

        companyProfile.setBalanceSheet(companyProfile.getBalanceSheet() - totalInterest);
        companyProfileRepository.save(companyProfile);

        System.out.println("Total interest deducted from company balance: " + totalInterest);
    }
}

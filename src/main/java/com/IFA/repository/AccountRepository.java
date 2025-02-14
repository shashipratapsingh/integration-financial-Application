package com.IFA.repository;

import com.IFA.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Accounts, UUID> {
    Optional<Accounts> findByAccountNumber(String accountNumber);
    Optional<Accounts> findByMobileNumber(String mobileNumber);
    @Query("SELECT a FROM Accounts a WHERE a.accountType = 'SAVINGS' AND a.createdAt <= :oneYearAgo")
    List<Accounts> findEligibleAccountsForInterest(LocalDateTime oneYearAgo);
}

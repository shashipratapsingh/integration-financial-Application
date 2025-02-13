package com.IFA.repository;

import com.IFA.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Accounts, UUID> {
    Optional<Accounts> findByAccountNumber(String accountNumber);
    Optional<Accounts> findByMobileNumber(String mobileNumber);
}

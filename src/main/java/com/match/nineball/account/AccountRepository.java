package com.match.nineball.account;

import com.match.nineball.account.enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByIdAndStatus(Long id, AccountStatus accountStatus);
}

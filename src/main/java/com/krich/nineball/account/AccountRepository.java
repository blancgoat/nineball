package com.krich.nineball.account;

import com.krich.nineball.account.enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Social, Long> {

    @Query("select s from Social s join fetch s.account where s.account.id = :id and s.account.status = :status")
    Social findSocialByAccountIdAndStatus(@Param(value = "id") Long id, @Param(value = "status") AccountStatus status);
}

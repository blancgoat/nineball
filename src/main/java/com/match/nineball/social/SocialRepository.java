package com.match.nineball.social;

import com.match.nineball.account.enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SocialRepository extends JpaRepository<Social, Long> {

    @Query("select s from Social s join fetch s.account where s.account.id = :id and s.account.status = :status")
    Social findSocialByAccountIdAndStatus(@Param(value = "id") Long id, @Param(value = "status") AccountStatus status);
}

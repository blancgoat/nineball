package com.match.nineball.account;

import com.match.nineball.account.enums.AccountStatus;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false,
            columnDefinition = "ENUM('ACTIVE', 'DELETE', 'IDLE') DEFAULT 'ACTIVE'")
    private AccountStatus status = AccountStatus.ACTIVE;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String phone;
}

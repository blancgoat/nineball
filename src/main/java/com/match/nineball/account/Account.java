package com.match.nineball.account;

import com.match.nineball.account.enums.AccountStatus;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false,
            name = "status",
            columnDefinition = "ENUM('ACTIVE', 'DELETE', 'IDLE') DEFAULT 'ACTIVE'")
    private AccountStatus status = AccountStatus.ACTIVE;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String phone;

    @Builder(builderMethodName = "builder")
    public Account(String nickname, String phone) {
        this.nickname = nickname;
        this.phone = phone;
    }

}

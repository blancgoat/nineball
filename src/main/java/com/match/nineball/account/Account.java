package com.match.nineball.account;

import com.match.nineball.account.enums.AccountStatus;
import com.match.nineball.social.Social;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "status",
            nullable = false,
            columnDefinition = "ENUM('ACTIVE', 'DELETE', 'IDLE') DEFAULT 'ACTIVE'")
    private AccountStatus status = AccountStatus.ACTIVE;

    @Column(nullable = false)
    private String nickname;

    @OneToOne(mappedBy = "account")
    private Social social;

    @Builder(builderMethodName = "builder")
    public Account(String nickname) {
        this.nickname = nickname;
    }

}

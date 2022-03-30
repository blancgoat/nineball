package com.match.nineball.social;

import com.match.nineball.account.Account;
import com.match.nineball.account.AccountRepository;
import com.match.nineball.social.enums.Provider;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "social")
public class Social {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "provider",
            nullable = false,
            columnDefinition = "ENUM('KAKAO') DEFAULT 'KAKAO'")
    private Provider provider = Provider.KAKAO;

    @Column(name = "auth_key", nullable = false)
    private String authKey;

    @Builder()
    public Social(Account account, Provider provider, String authKey) {
        this.account = account;
        this.provider = provider;
        this.authKey = authKey;
    }
}

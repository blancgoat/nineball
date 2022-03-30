package com.match.nineball.account;

import com.match.nineball.account.enums.AccountStatus;
import lombok.Builder;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", status=" + status +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && status == account.status && Objects.equals(nickname, account.nickname) && Objects.equals(phone, account.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, nickname, phone);
    }
}

package com.match.nineball.account.enums;

import lombok.Getter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Getter
public enum AccountStatus {
    ACTIVE("ACTIVE"),
    DELETE("DELETE"),
    IDLE("IDLE");

    private String accountStatus;

    AccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}

@Converter(autoApply = true)
class AccountStatusConverter implements AttributeConverter<AccountStatus, String> {

    @Override
    public String convertToDatabaseColumn(AccountStatus accountStatus) {
        if (accountStatus == null) {
            return null;
        }
        return accountStatus.getAccountStatus();
    }

    @Override
    public AccountStatus convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(AccountStatus.values())
                .filter(c -> c.getAccountStatus().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

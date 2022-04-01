package com.krich.nineball.account.dto;

import com.krich.nineball.account.Account;
import com.krich.nineball.account.Social;
import com.krich.nineball.account.enums.Provider;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CreateAccountDto {
    String nickname;
    Provider provider;
    String authKey;

    @Builder
    public CreateAccountDto(String nickname, Provider provider, String authKey) {
        this.nickname = nickname;
        this.provider = provider;
        this.authKey = authKey;
    }

    public Social toEntity() {
        return Social.builder()
                .account(Account.builder()
                        .nickname(nickname)
                        .build())
                .provider(provider)
                .authKey(authKey)
                .build();
    }
}

package com.match.nineball.social.dto;

import com.match.nineball.account.Account;
import com.match.nineball.account.dto.AccountDto;
import com.match.nineball.social.Social;
import com.match.nineball.social.enums.Provider;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SocialDto {
    String nickname;
    Provider provider;
    String authKey;

    @Builder
    public SocialDto(String nickname, Provider provider, String authKey) {
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

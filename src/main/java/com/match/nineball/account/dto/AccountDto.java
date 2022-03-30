package com.match.nineball.account.dto;

import com.match.nineball.account.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountDto {

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class AccountPostReq {
        private String nickname;
        private String phone;

        @Builder
        AccountPostReq(String nickname, String phone) {
            this.nickname = nickname;
            this.phone = phone;
        }

        public Account toEntity() {
            return Account.builder()
                    .nickname(nickname)
                    .phone(phone)
                    .build();
        }
    }
}

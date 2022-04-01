package com.krich.nineball.account;

import com.krich.nineball.account.enums.AccountStatus;
import com.krich.nineball.account.enums.Provider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class SocialRepositoryTest {

    @Autowired
    private SocialRepository socialRepository;
    @Autowired
    private AccountRepository accountRepository;
    private Social savedSocial;
    private String testNickName = "테스트닉네임";
    private Account testAccount = Account.builder().nickname(testNickName).build();
    private String testAuthKey = "testKey01";
    private Provider testProvider = Provider.KAKAO;

    @BeforeEach
    void init() {

        // given
        Social social = Social.builder()
                .account(testAccount)
                .authKey(testAuthKey)
                .provider(testProvider)
                .build();

        // when
        savedSocial = socialRepository.save(social);
    }

    @DisplayName("단순 저장테스트")
    @Test
    void save() {

        // then
        assertEquals(testNickName, savedSocial.getAccount().getNickname());
        assertEquals(testAccount, savedSocial.getAccount());
        assertEquals(testAuthKey, savedSocial.getAuthKey());
        assertEquals(testProvider, savedSocial.getProvider());
    }


    @DisplayName("social entity를 가져오지만 where id 는 account_id 기준으로 가져오는 쿼리 && status == 'ACTIVE'")
    @Test
    void findSocialByAccountIdAndStatus() {

        // then status == 'ACTIVE'
        assertThat(socialRepository.findSocialByAccountIdAndStatus(savedSocial.getAccount().getId(), AccountStatus.ACTIVE)).isEqualTo(savedSocial);
        assertThat(socialRepository.findSocialByAccountIdAndStatus(savedSocial.getAccount().getId(), AccountStatus.DELETE)).isNotEqualTo(savedSocial);

        // more
        // when
        accountRepository.save(Account.builder()
                .nickname("테스트 비소셜 회원")
                .build());
        Social savedSocial2 = socialRepository.save(Social.builder()
                .account(Account.builder().nickname("테스트 비소셜 회원").build())
                .authKey("00001231abcd")
                .provider(Provider.KAKAO)
                .build());

        // then savedSocial2.getAccount().getId() != savedSocial2.getId()
        assertThat(socialRepository.findSocialByAccountIdAndStatus(savedSocial2.getAccount().getId(), AccountStatus.ACTIVE)).isEqualTo(savedSocial2);
        assertThat(socialRepository.findSocialByAccountIdAndStatus(savedSocial2.getId(), AccountStatus.ACTIVE)).isNotEqualTo(savedSocial2);

    }
}
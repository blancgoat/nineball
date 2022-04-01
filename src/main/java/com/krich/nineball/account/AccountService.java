package com.krich.nineball.account;

import com.krich.nineball.account.enums.AccountStatus;
import com.krich.nineball.account.dto.CreateAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final SocialRepository socialRepository;

    @Transactional
    public Social createAccountAndSocial(CreateAccountDto req) {
        return socialRepository.save(req.toEntity());
    }

    @Transactional(readOnly = true)
    public Social getAccountAndSocialByAccountId(Long id) {
        return socialRepository.findSocialByAccountIdAndStatus(id, AccountStatus.ACTIVE);
    }

}

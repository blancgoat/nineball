package com.match.nineball.social;

import com.match.nineball.account.enums.AccountStatus;
import com.match.nineball.social.dto.SocialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SocialService {

    private final SocialRepository socialRepository;

    @Transactional
    public Social createSocial(SocialDto req) {
        return socialRepository.save(req.toEntity());
    }

    @Transactional(readOnly = true)
    public Social getSocialByAccountId(Long id) {
        return socialRepository.findSocialByAccountIdAndStatus(id, AccountStatus.ACTIVE);
    }

}

package com.match.nineball.account;

import com.match.nineball.account.dto.AccountDto;
import com.match.nineball.account.enums.AccountStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public Account getAccount(Long id) {
        return accountRepository.findByIdAndStatus(id, AccountStatus.ACTIVE);
    }

    @Transactional
    public Account createAccount(AccountDto.AccountPostReq req) {
        return accountRepository.save(req.toEntity());
    }
}

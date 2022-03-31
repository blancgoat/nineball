package com.match.nineball.account;

import com.match.nineball.account.dto.CreateAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping()
    public Social postAccount(@RequestBody CreateAccountDto req) {
        return accountService.createAccountAndSocial(req);
    }

    @GetMapping("/{id}")
    public Social getAccount(@PathVariable Long id) {
        return accountService.getAccountAndSocialByAccountId(id);
    }
}

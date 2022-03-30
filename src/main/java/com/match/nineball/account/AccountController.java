package com.match.nineball.account;

import com.match.nineball.account.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public Account postAccount(@RequestBody AccountDto.AccountPostReq req) {
        return accountService.createAccount(req);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}

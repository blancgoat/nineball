package com.match.nineball.social;

import com.match.nineball.account.Account;
import com.match.nineball.social.dto.SocialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/social")
public class SocialController {

    private final SocialService socialService;

    @PostMapping
    public Social postAccount(@RequestBody SocialDto req) {
        return socialService.createSocial(req);
    }
}

package com.match.nineball.social;

import com.match.nineball.social.dto.SocialDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/social")
public class SocialController {

    private final SocialService socialService;

    @PostMapping
    public Social postSocial(@RequestBody SocialDto req) {
        return socialService.createSocial(req);
    }

    @GetMapping("/{id}")
    public Social getSocial(@PathVariable Long id) {
        return socialService.getSocialByAccountId(id);
    }
}

package com.krich.nineball.player;

import com.krich.nineball.player.dto.RequestPlayerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public Player postPlayer(@RequestBody RequestPlayerDto requestPlayerDto) {
        return playerService.createPlayer(requestPlayerDto);
    }
}

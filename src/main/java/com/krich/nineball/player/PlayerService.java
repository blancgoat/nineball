package com.krich.nineball.player;

import com.krich.nineball.account.AccountRepository;
import com.krich.nineball.game.GameRepository;
import com.krich.nineball.player.dto.CreatePlayerDto;
import com.krich.nineball.player.dto.RequestPlayerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final AccountRepository accountRepository;
    private final GameRepository gameRepository;

    @Transactional
    public Player createPlayer(RequestPlayerDto requestPlayerDto) {
        return playerRepository.save(CreatePlayerDto.builder()
                .game(gameRepository.findById(requestPlayerDto.getGameId()).orElseThrow())
                .account(accountRepository.findById(requestPlayerDto.getAccountId()).orElseThrow())
                .isMaster(requestPlayerDto.getIsMaster())
                .team(requestPlayerDto.getTeam())
                .build().toEntity());
    }
}

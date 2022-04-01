package com.krich.nineball.game;

import com.krich.nineball.game.dto.CreateGameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    // todo :: response dto 생성해야함, 날짜와 gamePk만 존재하는
    @Transactional(readOnly = true)
    public Iterable<Game> getDatesActiveGame() {
        return gameRepository.findByIsDeleteOrderByGameStart(false);
    }

    @Transactional(readOnly = true)
    public Iterable<Game> getGamesByDate(LocalDate paramDate) {
        LocalDateTime fromDateTime = paramDate.atTime(LocalTime.of(0, 0, 0, 0));
        LocalDateTime toDateTime = paramDate.atTime(LocalTime.of(23, 59, 59, 999));
        return gameRepository.findByIsDeleteAndGameStartBetweenOrderByGameStart(false, fromDateTime, toDateTime);
    }

    @Transactional(readOnly = true)
    public Game getGame(Long id) {
        return gameRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Game createGame(CreateGameDto createGameDto) {
        return gameRepository.save(createGameDto.toEntity());
    }
}

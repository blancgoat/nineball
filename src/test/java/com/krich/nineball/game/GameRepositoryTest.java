package com.krich.nineball.game;

import com.krich.nineball.game.enums.GameType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;
    private Game savedGame1;
    private Game savedGame2;
    private LocalDateTime nowDateTime = LocalDateTime.now();

    @BeforeEach
    void init() {
        Game game1 = Game.builder()
                .address("서울 광진구")
                .addressX(55l)
                .addressY(199l)
                .gameStart(nowDateTime.plusDays(15l))
                .matchUpStart(nowDateTime.minusDays(14l))
                .matchUpEnd(nowDateTime.plusDays(15l))
                .gameType(GameType.TABLE_TENNIS)
                .build();

        Game game2 = Game.builder()
                .address("경남 창원시")
                .addressX(17l)
                .addressY(17l)
                .gameStart(nowDateTime.plusDays(2l))
                .matchUpStart(nowDateTime.minusDays(1l))
                .matchUpEnd(nowDateTime.plusDays(1l))
                .gameType(GameType.TABLE_TENNIS)
                .build();

        // when
        savedGame1 = gameRepository.save(game1);
        savedGame2 = gameRepository.save(game2);
    }

    @DisplayName("게임시작일 기준 가장빠른날 기준으로 정렬한다. 테스트는 가장빠른날의 게임을 찾으며 예상되는결과는 savedGame2를 찾는다.")
    @Test
    void findByIsDeleteOrderByGameStart() {

        // then
        Iterable<Game> Games = gameRepository.findByIsDeleteOrderByGameStart(false);
        Game checkGame = Games.iterator().next();
        assertEquals(checkGame, savedGame2);
        assertNotEquals(checkGame, savedGame1);
    }

    @DisplayName("당일에 시작하는 게임들을 찾는다. 테스트는 오늘로부터 2일뒤의 게임을 찾으며 예상되는결과는 savedGame2를 찾는다.")
    @Test
    void findByIsDeleteAndGameStartBetweenOrderByGameStart() {

        // then
        Iterable<Game> Games = gameRepository.findByIsDeleteAndGameStartBetweenOrderByGameStart(false,
                nowDateTime.plusDays(2l).with(LocalTime.of(0, 0, 0, 0)),
                nowDateTime.plusDays(2l).with(LocalTime.of(23, 59, 59, 999)));
        Game checkGame = Games.iterator().next();
        assertEquals(checkGame, savedGame2);
        assertNotEquals(checkGame, savedGame1);
    }
}
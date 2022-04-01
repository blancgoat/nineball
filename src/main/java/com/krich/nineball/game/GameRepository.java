package com.krich.nineball.game;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface GameRepository extends JpaRepository<Game, Long> {
    Iterable<Game> findByIsDeleteOrderByGameStart(Boolean isDelete);

    Iterable<Game> findByIsDeleteAndGameStartBetweenOrderByGameStart(Boolean isDelete, LocalDateTime fromDateTime, LocalDateTime toDateTime);
}

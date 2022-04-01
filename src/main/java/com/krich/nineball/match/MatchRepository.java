package com.krich.nineball.match;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface MatchRepository extends JpaRepository<Match, Long> {
    Iterable<Match> findByIsDeleteOrderByMatchStart(Boolean isDelete);

    Iterable<Match> findByIsDeleteAndMatchStartBetweenOrderByMatchStart(Boolean isDelete, LocalDateTime fromDate, LocalDateTime toDate);
}

package com.krich.nineball.match;

import com.krich.nineball.match.dto.MatchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    @Transactional(readOnly = true)
    public Iterable<Match> getDatesActiveMatch() {
        return matchRepository.findByIsDeleteOrderByMatchStart(false);
    }

    @Transactional(readOnly = true)
    public Iterable<Match> getMatchesByDate(LocalDateTime paramDate) {
        LocalDateTime fromDate = paramDate.with(LocalTime.of(0, 0, 0, 0));
        LocalDateTime toDate = paramDate.with(LocalTime.of(23, 59, 59, 999));
        return matchRepository.findByIsDeleteAndMatchStartBetweenOrderByMatchStart(false, fromDate, toDate);
    }

    @Transactional(readOnly = true)
    public Match getMatch(Long id) {
        return matchRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Match createMatch(MatchDto.MatchPostReq req) {
        return matchRepository.save(req.toEntity());
    }
}

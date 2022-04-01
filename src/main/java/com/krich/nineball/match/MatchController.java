package com.krich.nineball.match;

import com.krich.nineball.match.dto.MatchDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/match")
public class MatchController {

    private final MatchService matchService;

    @PostMapping
    public Match postMatch(@RequestBody MatchDto.MatchPostReq req) {
        return matchService.createMatch(req);
    }

    @GetMapping("/{id}")
    public Match getMatch(@PathVariable Long id) {
        return matchService.getMatch(id);
    }

    @GetMapping
    public Iterable<Match> getMatchesByDate(
            @DateTimeFormat(pattern = "yyyyMMddHHmmss")
            @Parameter(schema = @Schema(type = "string", format = "date", example = "20220217000000"))
            @RequestParam(name = "date") LocalDateTime paramDate) {
        return matchService.getMatchesByDate(paramDate);
    }
}

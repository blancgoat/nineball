package com.krich.nineball.game;

import com.krich.nineball.game.dto.CreateGameDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    private final GameService gameService;

    @PostMapping
    public Game postGame(@RequestBody CreateGameDto req) {
        return gameService.createGame(req);
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    @GetMapping
    public Iterable<Game> getGamesByDate(
            @DateTimeFormat(pattern = "yyyyMMddHHmmss")
            @Parameter(schema = @Schema(type = "string", format = "date", example = "20220217000000"))
            @RequestParam(name = "date") LocalDateTime paramDate) {
        return gameService.getGamesByDate(paramDate);
    }
}

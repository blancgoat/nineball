package com.krich.nineball.game.dto;

import com.krich.nineball.game.Game;
import com.krich.nineball.game.enums.GameType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CreateGameDto {

    private GameType gameType;
    private LocalDateTime matchUpStart;
    private LocalDateTime matchUpEnd;
    private LocalDateTime gameStart;
    private LocalDateTime gameEnd;
    private String address;
    private double addressX;
    private double addressY;

    @Builder
    public CreateGameDto(GameType gameType, LocalDateTime matchUpStart, LocalDateTime matchUpEnd, LocalDateTime gameStart, LocalDateTime gameEnd, String address, double addressX, double addressY) {
        this.gameType = gameType;
        this.matchUpStart = matchUpStart;
        this.matchUpEnd = matchUpEnd;
        this.gameStart = gameStart;
        this.gameEnd = gameEnd;
        this.address = address;
        this.addressX = addressX;
        this.addressY = addressY;
    }

    public Game toEntity() {
        return Game.builder()
                .gameType(gameType)
                .matchUpStart(matchUpStart)
                .matchUpEnd(matchUpEnd)
                .gameStart(gameStart)
                .gameEnd(gameEnd)
                .address(address)
                .addressX(addressX)
                .addressY(addressY)
                .build();
    }
}

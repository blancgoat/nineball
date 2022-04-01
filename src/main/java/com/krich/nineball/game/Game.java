package com.krich.nineball.game;

import com.krich.nineball.game.enums.GameType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    @Column(name = "game_type",
            nullable = false,
            columnDefinition = "ENUM('TABLE_TENNIS')")
    private GameType gameType;

    @Column(name = "match_up_start", nullable = false)
    private LocalDateTime matchUpStart;

    @Column(name = "match_up_end", nullable = false)
    private LocalDateTime matchUpEnd;

    @Column(name = "game_start", nullable = false)
    private LocalDateTime gameStart;

    @Column(name = "game_end")
    private LocalDateTime gameEnd;

    @Column(nullable = false)
    private String address;

    @Column(name = "address_x", nullable = false)
    private double addressX;

    @Column(name = "address_y", nullable = false)
    private double addressY;

    @Builder()
    public Game(GameType gameType, LocalDateTime matchUpStart, LocalDateTime matchUpEnd, LocalDateTime gameStart, LocalDateTime gameEnd, String address, double addressX, double addressY) {
        this.gameType = gameType;
        this.matchUpStart = matchUpStart;
        this.matchUpEnd = matchUpEnd;
        this.gameStart = gameStart;
        this.gameEnd = gameEnd;
        this.address = address;
        this.addressX = addressX;
        this.addressY = addressY;
    }
}

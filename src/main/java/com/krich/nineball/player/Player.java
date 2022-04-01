package com.krich.nineball.player;

import com.krich.nineball.account.Account;
import com.krich.nineball.game.Game;
import com.krich.nineball.player.enums.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    @Column(name = "is_master", nullable = false)
    private Boolean isMaster;

    @Column(name = "team",
            nullable = false,
            columnDefinition = "ENUM('RED', 'BLUE', 'WHITE')")
    private Team team;

    @Builder()
    public Player(Game game, Account account, Boolean isMaster, Team team) {
        this.game = game;
        this.account = account;
        this.isMaster = isMaster;
        this.team = team;
    }
}

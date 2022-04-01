package com.krich.nineball.player.dto;

import com.krich.nineball.account.Account;
import com.krich.nineball.game.Game;
import com.krich.nineball.player.Player;
import com.krich.nineball.player.enums.Team;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CreatePlayerDto {

    private Game game;
    private Account account;
    private Boolean isMaster;
    private Team team;

    @Builder
    public CreatePlayerDto(Game game, Account account, Boolean isMaster, Team team) {
        this.game = game;
        this.account = account;
        this.isMaster = isMaster;
        this.team = team;
    }

    public Player toEntity() {
        return Player.builder()
                .game(game)
                .account(account)
                .isMaster(isMaster)
                .team(team)
                .build();
    }
}

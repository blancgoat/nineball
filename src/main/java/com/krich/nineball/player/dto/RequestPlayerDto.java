package com.krich.nineball.player.dto;

import com.krich.nineball.account.Account;
import com.krich.nineball.game.Game;
import com.krich.nineball.player.Player;
import com.krich.nineball.player.enums.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RequestPlayerDto {

    private Long gameId;
    private Long accountId;
    private Boolean isMaster;
    private Team team;

//    public CreatePlayerDto toCreate(Game game, Account account) {
//        return CreatePlayerDto.builder()
//                .game(game)
//                .account(account)
//                .isMaster(isMaster)
//                .team(team)
//                .build();
//    }
//
//    public Player toEntity(Game game, Account account) {
//        return Player.builder()
//                .game(game)
//                .account(account)
//                .isMaster(isMaster)
//                .team(team)
//                .build();
//    }
}

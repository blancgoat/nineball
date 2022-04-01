package com.krich.nineball.player.dto;

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
}

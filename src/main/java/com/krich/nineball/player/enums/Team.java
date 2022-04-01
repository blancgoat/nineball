package com.krich.nineball.player.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Team {
    RED("RED"),
    BLUE("BLUE"),
    WHITE("WHITE");

    private String Team;
}

@Converter(autoApply = true)
class TeamConverter implements AttributeConverter<Team, String> {

    @Override
    public String convertToDatabaseColumn(Team team) {
        if (team == null) {
            return null;
        }
        return team.getTeam();
    }

    @Override
    public Team convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Team.values())
                .filter(c -> c.getTeam().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

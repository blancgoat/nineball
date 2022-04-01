package com.krich.nineball.game.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum GameType {
    TABLE_TENNIS("TABLE_TENNIS");

    private String gameType;
}

@Converter(autoApply = true)
class GameTypeConverter implements AttributeConverter<GameType, String> {

    @Override
    public String convertToDatabaseColumn(GameType gameType) {
        if (gameType == null) {
            return null;
        }
        return gameType.getGameType();
    }

    @Override
    public GameType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(GameType.values())
                .filter(c -> c.getGameType().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
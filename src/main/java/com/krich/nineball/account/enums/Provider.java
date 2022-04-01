package com.krich.nineball.account.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Provider {
    KAKAO("KAKAO");

    private String provider;
}

@Converter(autoApply = true)
class ProviderConverter implements AttributeConverter<Provider, String> {

    @Override
    public String convertToDatabaseColumn(Provider provider) {
        if (provider == null) {
            return null;
        }
        return provider.getProvider();
    }

    @Override
    public Provider convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Provider.values())
                .filter(c -> c.getProvider().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

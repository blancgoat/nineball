package com.krich.nineball.match.dto;

import com.krich.nineball.match.Match;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MatchDto {

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class MatchPostReq {
        private LocalDateTime matchUpStart;
        private LocalDateTime matchUpEnd;
        private LocalDateTime matchStart;
        private LocalDateTime matchEnd;
        private String address;
        private double addressX;
        private double addressY;

        @Builder
        public MatchPostReq(LocalDateTime matchUpStart, LocalDateTime matchUpEnd, LocalDateTime matchStart, LocalDateTime matchEnd, String address, double addressX, double addressY) {
            this.matchUpStart = matchUpStart;
            this.matchUpEnd = matchUpEnd;
            this.matchStart = matchStart;
            this.matchEnd = matchEnd;
            this.address = address;
            this.addressX = addressX;
            this.addressY = addressY;
        }

        public Match toEntity() {
            return Match.builder()
                    .matchUpStart(matchUpStart)
                    .matchUpEnd(matchUpEnd)
                    .matchStart(matchStart)
                    .matchEnd(matchEnd)
                    .address(address)
                    .addressX(addressX)
                    .addressY(addressY)
                    .build();
        }
    }
}

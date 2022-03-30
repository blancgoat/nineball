package com.match.nineball.room.dto;

import com.match.nineball.room.Room;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomDto {

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class RoomPostReq {
        private LocalDateTime matchUpStart;
        private LocalDateTime matchUpEnd;
        private LocalDateTime matchStart;
        private LocalDateTime matchEnd;
        private String address;
        private double addressX;
        private double addressY;

        @Builder
        public RoomPostReq(LocalDateTime matchUpStart, LocalDateTime matchUpEnd, LocalDateTime matchStart, LocalDateTime matchEnd, String address, double addressX, double addressY) {
            this.matchUpStart = matchUpStart;
            this.matchUpEnd = matchUpEnd;
            this.matchStart = matchStart;
            this.matchEnd = matchEnd;
            this.address = address;
            this.addressX = addressX;
            this.addressY = addressY;
        }

        public Room toEntity() {
            return Room.builder()
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

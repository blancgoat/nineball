package com.match.nineball.room;

import com.match.nineball.room.dto.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public Iterable<Room> getDatesActiveMatch() {
        return roomRepository.findByIsDeleteOrderByMatchStart(false);
    }

    @Transactional(readOnly = true)
    public Iterable<Room> getRoomsByDate(LocalDateTime paramDate) {
        LocalDateTime fromDate = paramDate.with(LocalTime.of(0, 0, 0, 0));
        LocalDateTime toDate = paramDate.with(LocalTime.of(23, 59, 59, 999));
        return roomRepository.findByIsDeleteAndMatchStartBetweenOrderByMatchStart(false, fromDate, toDate);
    }

    @Transactional(readOnly = true)
    public Room getRoom(Long id) {
        return roomRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Room createRoom(RoomDto.RoomPostReq req) {
        return roomRepository.save(req.toEntity());
    }
}

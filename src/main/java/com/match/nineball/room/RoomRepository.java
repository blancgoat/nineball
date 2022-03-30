package com.match.nineball.room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Iterable<Room> findByIsDeleteOrderByMatchStart(Boolean isDelete);

    Iterable<Room> findByIsDeleteAndMatchStartBetweenOrderByMatchStart(Boolean isDelete, LocalDateTime fromDate, LocalDateTime toDate);
}

package com.match.nineball.room;

import com.match.nineball.room.dto.RoomDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public Room postRoom(@RequestBody RoomDto.RoomPostReq req) {
        return roomService.createRoom(req);
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id) {
        return roomService.getRoom(id);
    }

    @GetMapping
    public Iterable<Room> getRoomsByDate(
            @DateTimeFormat(pattern = "yyyyMMddHHmmss")
            @Parameter(schema = @Schema(type = "string", format = "date", example = "20220217000000"))
            @RequestParam(name = "date") LocalDateTime paramDate) {
        return roomService.getRoomsByDate(paramDate);
    }
}

package com.match.nineball.room;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    @Column(name = "match_up_start", nullable = false)
    private LocalDateTime matchUpStart;

    @Column(name = "match_up_end", nullable = false)
    private LocalDateTime matchUpEnd;

    @Column(name = "match_start", nullable = false)
    private LocalDateTime matchStart;

    @Column(name = "match_end")
    private LocalDateTime matchEnd;

    @Column(nullable = false)
    private String address;

    @Column(name = "address_x", nullable = false)
    private double addressX;

    @Column(name = "address_y", nullable = false)
    private double addressY;

    @Builder()
    public Room(LocalDateTime matchUpStart, LocalDateTime matchUpEnd, LocalDateTime matchStart, LocalDateTime matchEnd, String address, double addressX, double addressY) {
        this.matchUpStart = matchUpStart;
        this.matchUpEnd = matchUpEnd;
        this.matchStart = matchStart;
        this.matchEnd = matchEnd;
        this.address = address;
        this.addressX = addressX;
        this.addressY = addressY;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", isDelete=" + isDelete +
                ", matchUpStart=" + matchUpStart +
                ", matchUpEnd=" + matchUpEnd +
                ", matchStart=" + matchStart +
                ", matchEnd=" + matchEnd +
                ", address='" + address + '\'' +
                ", addressX=" + addressX +
                ", addressY=" + addressY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Double.compare(room.addressX, addressX) == 0 && Double.compare(room.addressY, addressY) == 0 && Objects.equals(id, room.id) && Objects.equals(isDelete, room.isDelete) && Objects.equals(matchUpStart, room.matchUpStart) && Objects.equals(matchUpEnd, room.matchUpEnd) && Objects.equals(matchStart, room.matchStart) && matchEnd.equals(room.matchEnd) && Objects.equals(address, room.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isDelete, matchUpStart, matchUpEnd, matchStart, matchEnd, address, addressX, addressY);
    }
}

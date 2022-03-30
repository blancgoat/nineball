package com.match.nineball.room;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "address_x", nullable = false)
    private double addressX;

    @Column(name = "address_y", nullable = false)
    private double addressY;
}

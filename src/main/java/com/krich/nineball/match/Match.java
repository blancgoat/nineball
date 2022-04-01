package com.krich.nineball.match;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "match")
public class Match {

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
    public Match(LocalDateTime matchUpStart, LocalDateTime matchUpEnd, LocalDateTime matchStart, LocalDateTime matchEnd, String address, double addressX, double addressY) {
        this.matchUpStart = matchUpStart;
        this.matchUpEnd = matchUpEnd;
        this.matchStart = matchStart;
        this.matchEnd = matchEnd;
        this.address = address;
        this.addressX = addressX;
        this.addressY = addressY;
    }
}

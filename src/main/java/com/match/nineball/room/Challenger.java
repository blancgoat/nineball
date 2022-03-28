package com.match.nineball.room;

import com.match.nineball.account.Account;
import com.match.nineball.challenger.Room;

import javax.persistence.*;

@Entity
@Table(name = "challenger")
public class Challenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "is_master", nullable = false)
    private Boolean isMaster;
}

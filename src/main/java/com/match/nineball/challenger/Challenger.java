package com.match.nineball.challenger;

import com.match.nineball.account.Account;
import com.match.nineball.room.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
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

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    @Column(name = "is_master", nullable = false)
    private Boolean isMaster;
}

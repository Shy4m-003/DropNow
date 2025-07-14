package com.scrop.dropnow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Bookings")
@Getter
@Setter
@NoArgsConstructor

public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vehicle;
    private String type;
    private String pickup;
    private String destination;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingId", nullable = false)
    private UserEntity userEntity;
}

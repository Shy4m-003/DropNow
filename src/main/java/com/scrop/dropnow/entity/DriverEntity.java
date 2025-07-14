package com.scrop.dropnow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "DriverEntity")
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String emailId;
    @Column(nullable = false)
    private String password;
    private String licenseNumber;
    private String vehicle;
    private Long rating;
}

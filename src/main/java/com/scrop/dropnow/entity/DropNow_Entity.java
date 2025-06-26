package com.scrop.dropnow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
@Entity
@Table(name = "DN_users")
@Getter
@Setter
@NoArgsConstructor
public class DropNow_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(nullable = false)
    private String emailId;
    @Column(nullable = false)
    private String password;
}




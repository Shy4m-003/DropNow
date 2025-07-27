package com.scrop.dropnow.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "UserEntity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false,unique = true,length = 10)
    private String mobileNumber;
    @Column(nullable = false)
    private String password;
}

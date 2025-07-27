package com.scrop.dropnow.repository;

import com.scrop.dropnow.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity,Long> {
    Optional<UserDetailsEntity> findByUser_Id(long userId);
}

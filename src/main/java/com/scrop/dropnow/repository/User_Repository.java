package com.scrop.dropnow.repository;
import com.scrop.dropnow.entity.UserEntity;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface User_Repository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmailIdAndPassword(String emailId,String password);
    Optional<UserEntity> findByEmailId(String emailId);
    Optional<UserEntity> findByUserName(String userName);
}

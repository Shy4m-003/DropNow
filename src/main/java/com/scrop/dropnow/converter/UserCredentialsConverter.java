package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.DriverEntity;
import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.model.UserCredentialsDto;
import com.scrop.dropnow.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialsConverter {
    public UserCredentialsDto entitytoDto(UserEntity entity){
        UserCredentialsDto dto = new UserCredentialsDto();
        dto.setUserName(entity.getUserName());
        dto.setMobileNumber(entity.getMobileNumber());
        return dto;
    }
    public UserEntity dtoToEntity(UserCredentialsDto dto){
        UserEntity entity = new UserEntity();
        entity.setUserName(dto.getUserName());
        entity.setMobileNumber(dto.getUserName());
        entity.setPassword(dto.getPassword());
        return entity;
    }
    public UserCredentialsDto driverEntitytoDto(DriverEntity entity){
        UserCredentialsDto dto = new UserCredentialsDto();
        dto.setUserName(entity.getUserName());
        dto.setMobileNumber(entity.getMobileNumber());
        return dto;
    }
}

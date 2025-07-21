package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity dtoToEntity(UserDTO userDTO){
        UserEntity entity = new UserEntity();
        entity.setUserName(userDTO.getUserName());
        entity.setEmailId(userDTO.getEmailId());
        entity.setPassword(userDTO.getPassword());
        return entity;
    }
    public UserDTO entityToDto(UserEntity userEntity){
        UserDTO dto = new UserDTO();
        dto.setId(userEntity.getId());
        dto.setUserName(userEntity.getUserName());
        dto.setEmailId(userEntity.getEmailId());
        dto.setId(userEntity.getId());
        return dto;
    }
}

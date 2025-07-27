package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.UserDetailsEntity;
import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.model.UserDetailsDto;
import com.scrop.dropnow.repository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersDetailsConverter {
    @Autowired
    private User_Repository userRepository;
    public UserDetailsDto entityToDto(UserDetailsEntity entity){
        UserDetailsDto dto = new UserDetailsDto();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmailId(entity.getEmailId());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        dto.setLocation(entity.getEmailId());
        dto.setEmergencyContact(entity.getEmergencyContact());
        dto.setAddress(entity.getAddress());
        dto.setLocation(entity.getLocation());
        dto.setUserName(entity.getUser().getUserName());
        dto.setMobileNumber(entity.getUser().getMobileNumber());
        return dto;
    }
    public UserDetailsEntity dtoToEntity(UserDetailsDto dto){
        UserDetailsEntity entity = new UserDetailsEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAge(dto.getAge());
        entity.setEmailId(dto.getEmailId());
        entity.setGender(dto.getGender());
        entity.setLocation(dto.getEmailId());
        entity.setEmergencyContact(dto.getEmergencyContact());
        entity.setAddress(dto.getAddress());
        entity.setLocation(dto.getLocation());
        return entity;
    }
}

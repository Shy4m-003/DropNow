package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.DriverEntity;
import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.model.DriverDTO;
import com.scrop.dropnow.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class DriverConvertor {
    public DriverEntity dtoToEntity(DriverDTO dto){
        DriverEntity entity = new DriverEntity();
        entity.setUserName(dto.getUserName());
        entity.setEmailId(dto.getEmailId());
        entity.setPassword(dto.getPassword());
        entity.setLicenseNumber(dto.getLicenseNumber());
        entity.setVehicle(dto.getVehicle());
        entity.setRating(dto.getRating());
        return entity;
    }
    public DriverDTO entityToDto(DriverEntity entity){
        DriverDTO dto = new DriverDTO();
        dto.setUserName(entity.getUserName());
        dto.setEmailId(entity.getEmailId());
        dto.setPassword(entity.getPassword());
        dto.setLicenseNumber(entity.getLicenseNumber());
        dto.setVehicle(entity.getVehicle());
        dto.setRating(entity.getRating());
        return dto;
    }
}

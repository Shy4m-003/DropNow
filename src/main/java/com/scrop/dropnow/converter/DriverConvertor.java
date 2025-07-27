package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.DriverEntity;
import com.scrop.dropnow.model.DriverDTO;
import org.springframework.stereotype.Component;

@Component
public class DriverConvertor {
    public DriverEntity dtoToEntity(DriverDTO dto){
        DriverEntity entity = new DriverEntity();
        entity.setUserName(dto.getUserName());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setPassword(dto.getPassword());
        return entity;
    }
    public DriverDTO entityToDto(DriverEntity entity){
        DriverDTO dto = new DriverDTO();
        dto.setUserName(entity.getUserName());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setId(entity.getId());
        return dto;
    }
}

package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.VehicleEntity;
import com.scrop.dropnow.model.VehicleDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleConvertor {
    public VehicleEntity dtoToEntity(VehicleDto dto){
        VehicleEntity entity = new VehicleEntity();
        entity.setName(dto.getName());
        entity.setVehicleType(dto.getVehicleType());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        entity.setSeatingCapacity(dto.getSeatingCapacity());
        return entity;
    }
    public VehicleDto entityToDto(VehicleEntity entity){
        VehicleDto dto = new VehicleDto();
        dto.setName(entity.getName());
        dto.setVehicleType(entity.getVehicleType());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setSeatingCapacity(dto.getSeatingCapacity());
        dto.setDriverId(entity.getDriverEntity().getId());
        return dto;
    }
}

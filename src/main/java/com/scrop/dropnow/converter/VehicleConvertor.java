package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.VehicleEntity;
import com.scrop.dropnow.model.VehicleDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleConvertor {
    public VehicleEntity dtoToEntity(VehicleDto dto){
        VehicleEntity entity = new VehicleEntity();
        entity.setVehicleType(dto.getVehicleType());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        entity.setBrand(dto.getBrand());
        entity.setColor(dto.getColor());
        entity.setSeatingCapacity(dto.getSeatingCapacity());
        return entity;
    }
    public VehicleDto entityToDto(VehicleEntity entity){
        VehicleDto dto = new VehicleDto();
        dto.setVehicleType(entity.getVehicleType());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setBrand(entity.getBrand());
        dto.setColor(dto.getColor());
        dto.setSeatingCapacity(dto.getSeatingCapacity());
        dto.setDriverId(entity.getDriverEntity().getId());
        return dto;
    }
}

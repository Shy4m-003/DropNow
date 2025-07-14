package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.ReservationEntity;
import com.scrop.dropnow.model.ReservationRequestDto;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public ReservationEntity convertDtoToEntity(ReservationRequestDto requestDto){
        ReservationEntity entity = new ReservationEntity();
        entity.setVehicle(requestDto.getVehicle());
        entity.setType(requestDto.getType());
        entity.setPickup(requestDto.getPickup());
        entity.setDestination(requestDto.getDestination());
        entity.setPrice(requestDto.getPrice());
        return entity;
    }
    public ReservationRequestDto convertEntityToDto(ReservationEntity entity){
        ReservationRequestDto requestDto = new ReservationRequestDto();
        requestDto.setId(entity.getId());
        requestDto.setVehicle(entity.getVehicle());
        requestDto.setType(entity.getType());
        requestDto.setPickup(entity.getPickup());
        requestDto.setDestination(entity.getDestination());
        requestDto.setPrice(entity.getPrice());
        requestDto.setUserId(entity.getUserEntity().getId());
        return requestDto;
    }
}

package com.scrop.dropnow.converter;
import com.scrop.dropnow.entity.VehicleEntity;
import com.scrop.dropnow.model.DriverCardDto;
import com.scrop.dropnow.model.LocationDto;
import com.scrop.dropnow.service.Implemantation.PriceCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DriverCardConverter {
    @Autowired
    private PriceCalculationService priceCalculationService;
    public DriverCardDto entityToDto(VehicleEntity entity,LocationDto locationDto){
        DriverCardDto cardDto = new DriverCardDto();
        cardDto.setName(entity.getName());
        cardDto.setVehicleNumber(entity.getRegistrationNumber());
        cardDto.setVehicleType(entity.getVehicleType());
        cardDto.setPickUp(locationDto.getPickUp());
        cardDto.setDrop(locationDto.getDrop());
        double fare = priceCalculationService.calculateFare(cardDto.getVehicleType(), LocalTime.now());
        cardDto.setFare(fare);
        double distance = priceCalculationService.generateRandomDistance();
        cardDto.setDistance(distance);
        double time = priceCalculationService.getTimeMultiplier(LocalTime.now());
        cardDto.setTimeMultiplier(time);
        return cardDto;
    }
}

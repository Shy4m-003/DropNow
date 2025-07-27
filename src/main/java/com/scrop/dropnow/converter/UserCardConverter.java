package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.UserRequestEntity;
import com.scrop.dropnow.model.UserCardDto;
import com.scrop.dropnow.service.Implemantation.PriceCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
@Component
public class UserCardConverter {
    @Autowired
    private PriceCalculationService priceCalculationService;
    public UserCardDto entityToDto(UserRequestEntity entity){
        UserCardDto cardDto = new UserCardDto();
        cardDto.setUserId(entity.getUser().getId());
        cardDto.setName(entity.getName());
        cardDto.setPickUp(entity.getPickupLocation());
        cardDto.setDrop(entity.getDropLocation());
        double fare = priceCalculationService.calculateFare(entity.getVehicleType(), LocalTime.now());
        cardDto.setFare(fare);
        double distance = priceCalculationService.generateRandomDistance();
        cardDto.setDistance(distance);
        double time = priceCalculationService.getTimeMultiplier(LocalTime.now());
        cardDto.setTimeMultiplier(time);
        return cardDto;
    }

}

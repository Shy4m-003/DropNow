package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.RideHistoryEntity;
import com.scrop.dropnow.model.RideConfirmDto;
import org.springframework.stereotype.Component;

@Component
public class FetchDriverHistoryConvertor {
    public RideConfirmDto entityTODto(RideHistoryEntity entity){
        RideConfirmDto rideConfirmDto = new RideConfirmDto();
        rideConfirmDto.setVehicleNumber(entity.getVehicleNumber());
        rideConfirmDto.setFare(entity.getFare());
        rideConfirmDto.setDistance(entity.getDistance());
        rideConfirmDto.setTimeMultiplier(entity.getTimeMultiplier());
        rideConfirmDto.setPickupLocation(entity.getPickupLocation());
        rideConfirmDto.setDropLocation(entity.getDropLocation());
        rideConfirmDto.setUserName(entity.getUSER_NAME());
        return rideConfirmDto;
    }
}

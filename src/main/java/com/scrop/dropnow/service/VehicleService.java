package com.scrop.dropnow.service;

import com.scrop.dropnow.model.UserCredentialsDto;
import com.scrop.dropnow.model.VehicleDto;

public interface VehicleService {
    VehicleDto registerVehicle(VehicleDto dto);
    VehicleDto addOrUpdateVehicleDetails(VehicleDto dto,Long driverId);
    UserCredentialsDto updateCredentials(UserCredentialsDto dto, Long userId);
    VehicleDto getInfo(Long userId);
}

package com.scrop.dropnow.service;

import com.scrop.dropnow.entity.RideHistoryEntity;
import com.scrop.dropnow.model.RideConfirmDto;

import java.util.List;

public interface FetchRideHistoryService {
    List<RideConfirmDto> fetchUserRides(Long userId);
    List<RideConfirmDto> fetchDriverRides(Long driverId);
}

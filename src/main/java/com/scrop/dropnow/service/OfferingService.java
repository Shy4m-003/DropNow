package com.scrop.dropnow.service;

import com.scrop.dropnow.model.LocationDto;
import com.scrop.dropnow.model.RideConfirmDto;
import com.scrop.dropnow.model.UserCardDto;

import java.util.List;
import java.util.Map;

public interface OfferingService {
    Map<String, List<UserCardDto>> offer(String vehicleType);
    RideConfirmDto confirm(RideConfirmDto dto);
}

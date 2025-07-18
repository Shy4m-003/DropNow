package com.scrop.dropnow.service;

import com.scrop.dropnow.model.DriverCardDto;
import com.scrop.dropnow.model.LocationDto;
import com.scrop.dropnow.model.RideConfirmDto;

import java.util.List;
import java.util.Map;

public interface BookingService {
    Map<String, List<DriverCardDto>> book(LocationDto locationDto);
    void confirm(RideConfirmDto dto);
}

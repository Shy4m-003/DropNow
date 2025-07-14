package com.scrop.dropnow.service;

import com.scrop.dropnow.model.ReservationRequestDto;

import java.util.List;

public interface ReservationService {
	 ReservationRequestDto bookRide(ReservationRequestDto bookingRequestDto);
	 List<ReservationRequestDto> getAllInfo();
	 List<ReservationRequestDto> getInfoById(Long userId);
}

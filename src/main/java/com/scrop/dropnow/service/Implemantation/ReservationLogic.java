package com.scrop.dropnow.service.Implemantation;
import com.scrop.dropnow.converter.Converter;
import com.scrop.dropnow.entity.ReservationEntity;
import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.exceptions.BusinessException;
import com.scrop.dropnow.exceptions.ErrorModel;
import com.scrop.dropnow.model.ReservationRequestDto;
import com.scrop.dropnow.repository.Reservation_Repository;
import com.scrop.dropnow.repository.User_Repository;
import com.scrop.dropnow.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ReservationLogic implements ReservationService {
	@Autowired
	private Reservation_Repository reservationRepository;
	@Autowired
	private Converter converter;
	@Autowired
	private User_Repository userRepository;
	@Override
	public ReservationRequestDto bookRide(ReservationRequestDto bookingRequestDto) {
		Optional<UserEntity> optionalUserEntity = userRepository.findById(bookingRequestDto.getUserId());
		if (optionalUserEntity.isPresent()) {
			ReservationEntity reservationEntity = converter.convertDtoToEntity(bookingRequestDto);
			reservationEntity.setUserEntity(optionalUserEntity.get());
			reservationEntity = reservationRepository.save(reservationEntity);
			bookingRequestDto = converter.convertEntityToDto(reservationEntity);
		}else{
			List<ErrorModel> errorModelList = new ArrayList<>();
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode("Booking_Failed");
			errorModel.setMessage("User Doesn't Exist");
			errorModelList.add(errorModel);
			throw new BusinessException(errorModelList);
		}
			return bookingRequestDto;
	}

	@Override
	public List<ReservationRequestDto> getAllInfo() {
		List <ReservationEntity> list = (List<ReservationEntity>) reservationRepository.findAll();
		List<ReservationRequestDto> allList = new ArrayList<>();
		for(ReservationEntity entity : list){
			ReservationRequestDto reservationRequestDto = converter.convertEntityToDto(entity);
			allList.add(reservationRequestDto);
		}
		return allList;
	}

	@Override
	public List<ReservationRequestDto> getInfoById(Long userId) {
		List <ReservationEntity> list = (List<ReservationEntity>) reservationRepository.findAllByUserEntityId(userId);
		List<ReservationRequestDto> allList = new ArrayList<>();
		for(ReservationEntity entity : list){
			ReservationRequestDto reservationRequestDto = converter.convertEntityToDto(entity);
			allList.add(reservationRequestDto);
		}
		return allList;
	}
}

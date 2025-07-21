package com.scrop.dropnow.service.Implemantation;

import com.scrop.dropnow.converter.FetchDriverHistoryConvertor;
import com.scrop.dropnow.converter.FetchUserHistoryConvertor;
import com.scrop.dropnow.entity.RideHistoryEntity;
import com.scrop.dropnow.exceptions.BusinessException;
import com.scrop.dropnow.exceptions.ErrorModel;
import com.scrop.dropnow.model.RideConfirmDto;
import com.scrop.dropnow.repository.RideHistoryRepository;
import com.scrop.dropnow.service.FetchRideHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
@Service
public class FetchLogic implements FetchRideHistoryService {
    @Autowired
    private RideHistoryRepository repository;
    @Autowired
    private FetchUserHistoryConvertor fetchUserHistoryConvertor;
    @Autowired
    private FetchDriverHistoryConvertor fetchDriverHistoryConvertor;
    @Override
    public List<RideConfirmDto> fetchUserRides(Long userId) {
        List<RideHistoryEntity> rideHistoryList = repository.findAllByUserEntity_Id(userId);
        if (rideHistoryList.isEmpty()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("NO_BOOKINGS");
            errorModel.setMessage("Start Booking Now");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }

        return rideHistoryList.stream()
                .map(fetchUserHistoryConvertor::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RideConfirmDto> fetchDriverRides(Long driverId) {
        List<RideHistoryEntity> entities = repository.findAllByDriverEntity_Id(driverId);
        if(entities.isEmpty()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("NO_BOOKINGS");
            errorModel.setMessage("Get Hired Now");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return entities.stream()
                .map(fetchDriverHistoryConvertor::entityTODto)
                .collect(Collectors.toList());
    }
}

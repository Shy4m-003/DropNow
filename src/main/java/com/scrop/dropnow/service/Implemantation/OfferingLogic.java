package com.scrop.dropnow.service.Implemantation;

import com.scrop.dropnow.converter.RideConfirmConverter;
import com.scrop.dropnow.converter.UserCardConverter;
import com.scrop.dropnow.entity.RideHistoryEntity;
import com.scrop.dropnow.entity.UserRequestEntity;
import com.scrop.dropnow.model.RideConfirmDto;
import com.scrop.dropnow.model.UserCardDto;
import com.scrop.dropnow.repository.RideHistoryRepository;
import com.scrop.dropnow.repository.UserRequestRepository;
import com.scrop.dropnow.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class OfferingLogic implements OfferingService {
    @Autowired
    private UserRequestRepository userRequestRepository;
    @Autowired
    private UserCardConverter userCardConverter;
    @Autowired
    private RideConfirmConverter rideConfirmConverter;
    @Autowired
    private RideHistoryRepository repository;
    @Override
    public Map<String, List<UserCardDto>> offer(String vehicleType) {
        Map<String, List<UserCardDto>> categorizedUsers = new HashMap<>();

        if (vehicleType.equals("Two Wheeler")) {
            List<UserRequestEntity> bikeList = userRequestRepository.findByVehicleType("Two Wheeler");
            categorizedUsers.put("bike", bikeList.stream()
                    .map(userCardConverter::entityToDto)
                    .collect(Collectors.toList()));
            return categorizedUsers;
        }

        if (vehicleType.equals("Three Wheeler")) {
            List<UserRequestEntity> autoList = userRequestRepository.findByVehicleType("Three Wheeler");
            categorizedUsers.put("auto", autoList.stream()
                    .map(userCardConverter::entityToDto)
                    .collect(Collectors.toList()));
            return categorizedUsers;
        }

        if (vehicleType.equals("Four Wheeler")) {
            List<UserRequestEntity> carList = userRequestRepository.findByVehicleType("Four Wheeler");
            categorizedUsers.put("car", carList.stream()
                    .map(userCardConverter::entityToDto)
                    .collect(Collectors.toList()));
            return categorizedUsers;
        }

        if (vehicleType.equals("Four Wheeler-lux")) {
            List<UserRequestEntity> luxCarList = userRequestRepository.findByVehicleType("Four Wheeler-lux");
            categorizedUsers.put("luxuryCar", luxCarList.stream()
                    .map(userCardConverter::entityToDto)
                    .collect(Collectors.toList()));
            return categorizedUsers;
        }

        return categorizedUsers; // empty map if no match
    }
    @Override
    public RideConfirmDto confirm(RideConfirmDto dto) {
        RideHistoryEntity rideHistoryEntity = rideConfirmConverter.dtoToEntity(dto);
        rideHistoryEntity = repository.save(rideHistoryEntity);
        dto = rideConfirmConverter.entityTODto(rideHistoryEntity);
        return dto;
    }
}

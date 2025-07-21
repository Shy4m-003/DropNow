package com.scrop.dropnow.service.Implemantation;

import com.scrop.dropnow.converter.DriverCardConverter;
import com.scrop.dropnow.converter.RideConfirmConverter;
import com.scrop.dropnow.entity.RideHistoryEntity;
import com.scrop.dropnow.entity.VehicleEntity;
import com.scrop.dropnow.model.DriverCardDto;
import com.scrop.dropnow.model.LocationDto;
import com.scrop.dropnow.model.RideConfirmDto;
import com.scrop.dropnow.repository.RideHistoryRepository;
import com.scrop.dropnow.repository.VehicleRepository;
import com.scrop.dropnow.service.BookingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingLogic implements BookingService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private DriverCardConverter driverCardConverter;
    @Autowired
    private RideConfirmConverter rideConfirmConverter;
    @Autowired
    private RideHistoryRepository repository;
    @Override
    public Map<String, List<DriverCardDto>> book(LocationDto locationDto) {
        List<VehicleEntity> bikeList = vehicleRepository.findByVehicleType("Two Wheeler");
        List<VehicleEntity> autoList = vehicleRepository.findByVehicleType("Three Wheeler");
        List<VehicleEntity> carList = vehicleRepository.findByVehicleType("Four Wheeler");
        List<VehicleEntity> luxCarList = vehicleRepository.findByVehicleType("Four Wheeler-lux");
        Map<String, List<DriverCardDto>> categorizedDrivers = new HashMap<>();

        categorizedDrivers.put("bike", bikeList.stream()
                .map(entity -> driverCardConverter.entityToDto(entity, locationDto))
                .collect(Collectors.toList()));

        categorizedDrivers.put("auto", autoList.stream()
                .map(entity -> driverCardConverter.entityToDto(entity, locationDto))
                .collect(Collectors.toList()));

        categorizedDrivers.put("car", carList.stream()
                .map(entity -> driverCardConverter.entityToDto(entity, locationDto))
                .collect(Collectors.toList()));

        categorizedDrivers.put("luxuryCar", luxCarList.stream()
                .map(entity -> driverCardConverter.entityToDto(entity, locationDto))
                .collect(Collectors.toList()));

        return categorizedDrivers;
    }

    @Override
    public RideConfirmDto confirm(RideConfirmDto dto) {
        RideHistoryEntity rideHistoryEntity = rideConfirmConverter.dtoToEntity(dto);
        rideHistoryEntity = repository.save(rideHistoryEntity);
        dto = rideConfirmConverter.entityTODto(rideHistoryEntity);
        return dto;
    }
}

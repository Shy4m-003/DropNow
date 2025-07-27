package com.scrop.dropnow.service.Implemantation;

import com.scrop.dropnow.converter.UserCredentialsConverter;
import com.scrop.dropnow.converter.VehicleConvertor;
import com.scrop.dropnow.entity.DriverEntity;
import com.scrop.dropnow.entity.UserDetailsEntity;
import com.scrop.dropnow.entity.VehicleEntity;
import com.scrop.dropnow.exceptions.BusinessException;
import com.scrop.dropnow.exceptions.ErrorModel;
import com.scrop.dropnow.model.UserCredentialsDto;
import com.scrop.dropnow.model.VehicleDto;
import com.scrop.dropnow.repository.DriverRepository;
import com.scrop.dropnow.repository.VehicleRepository;
import com.scrop.dropnow.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleLogic implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleConvertor convertor;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private UserCredentialsConverter userCredentialsConverter;

    @Override
    public VehicleDto registerVehicle(VehicleDto dto) {
        Optional<DriverEntity> optionalDriverEntity = driverRepository.findById(dto.getDriverId());
        if (optionalDriverEntity.isPresent()) {
            VehicleEntity entity = convertor.dtoToEntity(dto);
            entity.setDriverEntity(optionalDriverEntity.get()); //Link to between Two Tables
            entity = vehicleRepository.save(entity);
            dto = convertor.entityToDto(entity);
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Booking_Failed");
            errorModel.setMessage("User Doesn't Exist");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return dto;
    }

    @Override
    public VehicleDto addOrUpdateVehicleDetails(VehicleDto dto, Long driverId) {
        Optional<DriverEntity> driverOptional = driverRepository.findById(driverId);

        if (driverOptional.isEmpty()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("NOT_REGISTERED");
            errorModel.setMessage("Please register to add additional details");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }

        DriverEntity driver = driverOptional.get();

        // Find vehicle by driver entity (since it's one-to-one)
        Optional<VehicleEntity> existingVehicle = vehicleRepository.findByDriverEntity(driver);

        VehicleEntity vehicleEntity;

        if (existingVehicle.isPresent()) {
            vehicleEntity = existingVehicle.get();
        } else {
            vehicleEntity = new VehicleEntity();
            vehicleEntity.setDriverEntity(driver); // assign driver only once (required, not null)
        }

        // Set/update fields
        vehicleEntity.setName(dto.getName());
        vehicleEntity.setVehicleType(dto.getVehicleType());
        vehicleEntity.setRegistrationNumber(dto.getRegistrationNumber());
        vehicleEntity.setSeatingCapacity(dto.getSeatingCapacity());

        VehicleEntity savedEntity = vehicleRepository.save(vehicleEntity);
        return convertor.entityToDto(savedEntity);
    }

    @Override
    public UserCredentialsDto updateCredentials(UserCredentialsDto dto, Long userId) {
        Optional<DriverEntity> optionalUser = driverRepository.findById(userId);
        if (optionalUser.isPresent()) {
            DriverEntity existingUser = optionalUser.get();
            if (!existingUser.getPassword().equals(dto.getExistingPassword())) {
                throw new RuntimeException("Invalid existing password");
            }

            // ✅ Only update fields if they are not null
            if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
                existingUser.setPassword(dto.getPassword());
            }

            if (dto.getMobileNumber() != null && !dto.getMobileNumber().isBlank()) {
                existingUser.setMobileNumber(dto.getMobileNumber());
            }

            if (dto.getUserName() != null && !dto.getUserName().isBlank()) {
                existingUser.setUserName(dto.getUserName());
            }

            DriverEntity updatedUser = driverRepository.save(existingUser);
            return userCredentialsConverter.driverEntitytoDto(existingUser);
        } else {
            List<ErrorModel> errors = new ArrayList<>();
            ErrorModel error = new ErrorModel();
            error.setCode("NOT_FOUND");
            error.setMessage("User not found");
            errors.add(error);
            throw new BusinessException(errors);
        }
    }

    @Override
    public VehicleDto getInfo(Long driverId) {
        Optional<VehicleEntity> userInfo = vehicleRepository.findBydriverEntity_Id(driverId);
        if(userInfo.isPresent()){
            return convertor.entityToDto(userInfo.get());
        }
        List<ErrorModel> errors = new ArrayList<>();
        ErrorModel error = new ErrorModel();
        error.setCode("NOT_FOUND");
        error.setMessage("User not found");
        errors.add(error);
        throw new BusinessException(errors);
    }
}

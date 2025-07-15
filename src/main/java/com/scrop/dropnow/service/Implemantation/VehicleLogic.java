package com.scrop.dropnow.service.Implemantation;

import com.scrop.dropnow.converter.VehicleConvertor;
import com.scrop.dropnow.entity.DriverEntity;
import com.scrop.dropnow.entity.VehicleEntity;
import com.scrop.dropnow.exceptions.BusinessException;
import com.scrop.dropnow.exceptions.ErrorModel;
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
    @Override
    public VehicleDto registerVehicle(VehicleDto dto) {
        Optional<DriverEntity> optionalDriverEntity = driverRepository.findById(dto.getDriverId());
        if(optionalDriverEntity.isPresent()){
            VehicleEntity entity = convertor.dtoToEntity(dto);
            entity.setDriverEntity(optionalDriverEntity.get()); //Link to between Two Tables
            entity = vehicleRepository.save(entity);
            dto = convertor.entityToDto(entity);
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Booking_Failed");
            errorModel.setMessage("User Doesn't Exist");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return dto;
    }
}

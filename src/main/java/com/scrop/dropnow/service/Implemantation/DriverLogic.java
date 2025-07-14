package com.scrop.dropnow.service.Implemantation;

import com.scrop.dropnow.converter.DriverConvertor;
import com.scrop.dropnow.entity.DriverEntity;
import com.scrop.dropnow.exceptions.BusinessException;
import com.scrop.dropnow.exceptions.ErrorModel;
import com.scrop.dropnow.model.DriverDTO;
import com.scrop.dropnow.repository.DriverRepository;
import com.scrop.dropnow.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class DriverLogic implements DriverService {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private DriverConvertor driverConvertor;
    @Override
    public DriverDTO register(DriverDTO driverDTO) {
        Optional<DriverEntity> optionalDriverEntity = driverRepository.findByEmailId(driverDTO.getEmailId());
        Optional<DriverEntity> driverEntityOptional = driverRepository.findByUserName(driverDTO.getUserName());
        if(optionalDriverEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Email_Already_Exist");
            errorModel.setMessage("The Email You Entered already Exist");
            throw new BusinessException(errorModelList);
        }
        if(driverEntityOptional.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("User_Name_Exist");
            errorModel.setMessage("The username your entered is already in use");
            throw new BusinessException(errorModelList);
        }
        DriverEntity entity = driverConvertor.dtoToEntity(driverDTO);
        entity = driverRepository.save(entity);
        driverDTO = driverConvertor.entityToDto(entity);
        return driverDTO;
    }
    @Override
    public DriverDTO login(String userName, String password) {
        DriverDTO dto = null;
        Optional<DriverEntity> optionalDriverEntity = driverRepository.findByUserNameAndPassword(userName,password);
        if(optionalDriverEntity.isPresent()){
            dto  = driverConvertor.entityToDto(optionalDriverEntity.get());
        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Invalid_Login");
            errorModel.setMessage("Invalid User Name or Password");
            throw new BusinessException(errorModelList);
        }
        return dto;
    }
}

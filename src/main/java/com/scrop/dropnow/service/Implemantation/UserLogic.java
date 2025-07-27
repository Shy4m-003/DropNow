package com.scrop.dropnow.service.Implemantation;

import com.scrop.dropnow.converter.UserConverter;
import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.exceptions.BusinessException;
import com.scrop.dropnow.exceptions.ErrorModel;
import com.scrop.dropnow.model.UserDTO;
import com.scrop.dropnow.repository.User_Repository;
import com.scrop.dropnow.service.UserService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserLogic implements UserService {
    @Autowired
    private User_Repository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDetails) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByMobileNumber(userDetails.getMobileNumber());
        if(optionalUserEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Mobile_Number_Exist");
            errorModel.setMessage("The Mobile Number You Entered already Exist, Please Login");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        UserEntity entity = userConverter.dtoToEntity(userDetails);
        entity = userRepository.save(entity);
        userDetails = userConverter.entityToDto(entity);
        System.out.println("DEBUG - Entity Email: " + entity.getMobileNumber());
        System.out.println("Saving entity: " + entity);
        return userDetails;
    }

    @Override
    public UserDTO login(String mobileNumber, String password) {
        UserDTO userDto = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByMobileNumberAndPassword(mobileNumber,password);
        if(optionalUserEntity.isPresent()){
            userDto = userConverter.entityToDto(optionalUserEntity.get());
        }
        else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Invalid Login");
            errorModel.setMessage("Invalid Mobile Number or Password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return userDto;
    }

    @Override
    public UserDTO getInfoByUserName(String userName) {
        Optional<UserEntity> entity = userRepository.findByUserName(userName);
        if (entity.isPresent()) {
            return userConverter.entityToDto(entity.get());
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Invalid Login");
            errorModel.setMessage("Invalid EmailId or Password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
    }
}

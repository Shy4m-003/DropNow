package com.scrop.dropnow.service;

import com.scrop.dropnow.converter.UserConverter;
import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.exceptions.BusinessException;
import com.scrop.dropnow.exceptions.ErrorModel;
import com.scrop.dropnow.model.UserDTO;
import com.scrop.dropnow.repository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserLogic implements UserService{
    @Autowired
    private User_Repository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDetails) {
        UserEntity entity = userConverter.dtoToEntity(userDetails);
        entity = userRepository.save(entity);
        userDetails = userConverter.entityToDto(entity);
        System.out.println("DEBUG - DTO Email: " + userDetails.getEmailId());
        System.out.println("DEBUG - Entity Email: " + entity.getEmailId());
        System.out.println("Saving entity: " + entity);
        return userDetails;
    }

    @Override
    public UserDTO login(String userName, String password) {
        UserDTO userDto = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserNameAndPassword(userName,password);
        if(optionalUserEntity.isPresent()){
            userDto = userConverter.entityToDto(optionalUserEntity.get());
        }
        else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Invalid Login");
            errorModel.setMessage("Invalid EmailId or Password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return userDto;
    }
}

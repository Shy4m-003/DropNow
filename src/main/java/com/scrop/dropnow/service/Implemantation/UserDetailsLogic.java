package com.scrop.dropnow.service.Implemantation;

import com.scrop.dropnow.converter.UserConverter;
import com.scrop.dropnow.converter.UserCredentialsConverter;
import com.scrop.dropnow.converter.UsersDetailsConverter;
import com.scrop.dropnow.entity.UserDetailsEntity;
import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.exceptions.BusinessException;
import com.scrop.dropnow.exceptions.ErrorModel;
import com.scrop.dropnow.model.UserCredentialsDto;
import com.scrop.dropnow.model.UserDTO;
import com.scrop.dropnow.model.UserDetailsDto;
import com.scrop.dropnow.repository.UserDetailsRepository;
import com.scrop.dropnow.repository.User_Repository;
import com.scrop.dropnow.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserDetailsLogic implements UserDetailsService {
    @Autowired
    private UsersDetailsConverter usersDetailsConverter;
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private User_Repository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserCredentialsConverter converter;
    @Override
    public UserDetailsDto addOrUpdateUserDetails(UserDetailsDto userDetailsDto,Long userId) {
        Optional<UserEntity> optionalUserDetailsEntity = userRepository.findById(userId);
        if(optionalUserDetailsEntity.isEmpty()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("N0T_REGISTERED");
            errorModel.setMessage("Please Register to add Additional details");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        Optional<UserDetailsEntity> existingDetailsOpt = userDetailsRepository.findByUser_Id(userId);
        UserDetailsEntity savedEntity;
        if(existingDetailsOpt.isPresent()){
            UserDetailsEntity existingDetails = existingDetailsOpt.get();
           existingDetails.setFirstName(userDetailsDto.getFirstName());
           existingDetails.setLastName(userDetailsDto.getLastName());
           existingDetails.setEmailId(userDetailsDto.getEmailId());
           existingDetails.setEmergencyContact(userDetailsDto.getEmergencyContact());
           existingDetails.setAddress(userDetailsDto.getAddress());
           existingDetails.setLocation(userDetailsDto.getLocation());
           existingDetails.setGender(userDetailsDto.getGender());
           existingDetails.setAge(userDetailsDto.getAge());
           savedEntity = userDetailsRepository.save(existingDetails);
        }else {
            // Insert new details
            UserDetailsEntity newDetails = usersDetailsConverter.dtoToEntity(userDetailsDto);
            newDetails.setUser(optionalUserDetailsEntity.get());  // Link with UserEntity
            savedEntity = userDetailsRepository.save(newDetails);
        }
        return usersDetailsConverter.entityToDto(savedEntity);
    }

    @Override
    public UserCredentialsDto updateCredentials(UserCredentialsDto dto, Long userId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
            if (optionalUser.isPresent()) {
                UserEntity existingUser = optionalUser.get();
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

                UserEntity updatedUser = userRepository.save(existingUser);
                return converter.entitytoDto(updatedUser);
            }else{
                    List<ErrorModel> errors = new ArrayList<>();
                    ErrorModel error = new ErrorModel();
                    error.setCode("NOT_FOUND");
                    error.setMessage("User not found");
                    errors.add(error);
                    throw new BusinessException(errors);
                }
        }

    @Override
    public UserDetailsDto getUserInfo(Long userId) {
        Optional<UserDetailsEntity> userInfo = userDetailsRepository.findByUser_Id(userId);
        if(userInfo.isPresent()){
            return usersDetailsConverter.entityToDto(userInfo.get());
        }
        List<ErrorModel> errors = new ArrayList<>();
        ErrorModel error = new ErrorModel();
        error.setCode("NOT_FOUND");
        error.setMessage("User not found");
        errors.add(error);
        throw new BusinessException(errors);
    }
}

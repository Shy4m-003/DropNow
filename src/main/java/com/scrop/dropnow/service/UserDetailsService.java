package com.scrop.dropnow.service;

import com.scrop.dropnow.model.UserCredentialsDto;
import com.scrop.dropnow.model.UserDetailsDto;


public interface UserDetailsService {
    UserDetailsDto addOrUpdateUserDetails(UserDetailsDto userDetailsDto,Long userId);
    UserCredentialsDto updateCredentials(UserCredentialsDto dto, Long userId);
    UserDetailsDto getUserInfo(Long userId);

}

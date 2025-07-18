package com.scrop.dropnow.service;

import com.scrop.dropnow.model.UserDTO;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    UserDTO register(UserDTO userDetails);
    UserDTO login(String userName,String password );
    UserDTO getInfoByUserName(String userName);
}

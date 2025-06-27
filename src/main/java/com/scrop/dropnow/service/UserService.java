package com.scrop.dropnow.service;

import com.scrop.dropnow.model.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDetails);
    UserDTO login(String userName,String password );
}

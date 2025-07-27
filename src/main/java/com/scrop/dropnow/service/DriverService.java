package com.scrop.dropnow.service;

import com.scrop.dropnow.model.DriverDTO;



public interface DriverService {
    DriverDTO register(DriverDTO driverDTO);
    DriverDTO login(String userName,String password );
    DriverDTO getInfoByUserId(Long id);
}

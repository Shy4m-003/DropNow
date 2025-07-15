package com.scrop.dropnow.controller;

import com.scrop.dropnow.model.DriverDTO;
import com.scrop.dropnow.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/DropNow")
public class DriverController {
    @Autowired
    private DriverService service;
    @PostMapping("/driver-registration")
    public ResponseEntity<DriverDTO> register(@RequestBody DriverDTO driverdto){
        driverdto = service.register(driverdto);
        return new ResponseEntity<>(driverdto, HttpStatus.CREATED);
    }
}

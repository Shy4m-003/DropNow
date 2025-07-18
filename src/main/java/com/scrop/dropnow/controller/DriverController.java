package com.scrop.dropnow.controller;

import com.scrop.dropnow.model.DriverDTO;
import com.scrop.dropnow.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/DropNow/driver")
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {
    @Autowired
    private DriverService service;
    @PostMapping(path = "/registration" ,consumes = {"application/json"} , produces = {"application/json"})
    public ResponseEntity<DriverDTO> register(@RequestBody DriverDTO driverdto){
        driverdto = service.register(driverdto);
        return new ResponseEntity<>(driverdto, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<DriverDTO> login(@RequestBody DriverDTO dto){
        dto = service.login(dto.getEmailId(),dto.getPassword());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping("/dashboard/{userName}")
    public ResponseEntity<DriverDTO> getInfoByUserName(@PathVariable String userName){
        DriverDTO dto = service.getInfoByUserName(userName);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}


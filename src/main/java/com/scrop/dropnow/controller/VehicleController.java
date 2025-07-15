package com.scrop.dropnow.controller;
import com.scrop.dropnow.model.VehicleDto;
import com.scrop.dropnow.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/DropNow")
public class VehicleController {
    @Autowired
    private VehicleService service;
    @PostMapping("/vehicle/register")
    public ResponseEntity<VehicleDto> registerVehicle(@RequestBody VehicleDto dto){
        dto = service.registerVehicle(dto);
        return new ResponseEntity<>(dto , HttpStatus.CREATED);
    }
}

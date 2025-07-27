package com.scrop.dropnow.controller;
import com.scrop.dropnow.model.UserCredentialsDto;
import com.scrop.dropnow.model.UserDetailsDto;
import com.scrop.dropnow.model.VehicleDto;
import com.scrop.dropnow.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/DropNow")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {
    @Autowired
    private VehicleService service;
    @PostMapping("/vehicle/register")
    public ResponseEntity<VehicleDto> registerVehicle(@RequestBody VehicleDto dto){
        dto = service.registerVehicle(dto);
        return new ResponseEntity<>(dto , HttpStatus.CREATED);
    }
    @PatchMapping("/edit-vehicle-details/{driverId}")
    public ResponseEntity<VehicleDto> addOrUpdateVehicle(@RequestBody VehicleDto dto, @PathVariable Long driverId) {
        VehicleDto updatedDto = service.addOrUpdateVehicleDetails(dto, driverId);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }
    @PatchMapping("/edit-info/{driverId}")
    public ResponseEntity<UserCredentialsDto> updateCredentials(@RequestBody UserCredentialsDto dto, @PathVariable Long driverId){
        dto = service.updateCredentials(dto,driverId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/driver-info/{driverId}")
    public ResponseEntity<VehicleDto> getUserInfo(@PathVariable Long driverId){
        VehicleDto dto = service.getInfo(driverId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}

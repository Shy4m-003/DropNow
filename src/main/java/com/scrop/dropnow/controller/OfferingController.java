package com.scrop.dropnow.controller;

import com.scrop.dropnow.model.DriverCardDto;
import com.scrop.dropnow.model.RideConfirmDto;
import com.scrop.dropnow.model.UserCardDto;
import com.scrop.dropnow.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/DropNow/driver")
public class OfferingController {
    @Autowired
    private OfferingService offeringService;
    @GetMapping("/offer-ride/{vehicleType}")
    public ResponseEntity<Map<String, List<UserCardDto>>> offer(@PathVariable String vehicleType){
        Map<String, List<UserCardDto>> userCardMap = offeringService.offer(vehicleType);
        return ResponseEntity.ok(userCardMap);
    }
    @PostMapping("/picked")
    public ResponseEntity<RideConfirmDto> confirm(@RequestBody RideConfirmDto rideConfirmDto){
        rideConfirmDto = offeringService.confirm(rideConfirmDto);
        return new ResponseEntity<>(rideConfirmDto, HttpStatus.OK);
    }
}

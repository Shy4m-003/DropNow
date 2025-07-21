package com.scrop.dropnow.controller;

import com.scrop.dropnow.model.RideConfirmDto;
import com.scrop.dropnow.service.Implemantation.FetchLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/DropNow/history")
@CrossOrigin(origins = "http://localhost:4200")
public class FetchController {
    @Autowired
    private FetchLogic fetch;
    @GetMapping("/rides/{userId}")
    public ResponseEntity<List<RideConfirmDto>> fetchUserRides(@PathVariable Long userId){
        List<RideConfirmDto> historyList = fetch.fetchUserRides(userId);
        return new ResponseEntity<>(historyList, HttpStatus.OK);
    }
    @GetMapping("/rides-history/{driverId}")
    public ResponseEntity<List<RideConfirmDto>> fetchDriverRides(@PathVariable Long driverId){
        List<RideConfirmDto> historyList = fetch.fetchDriverRides(driverId);
        return new ResponseEntity<>(historyList, HttpStatus.OK);
    }
}

package com.scrop.dropnow.controller;


import com.scrop.dropnow.model.ReservationRequestDto;
import com.scrop.dropnow.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/DropNow/user")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @PostMapping("/Book-Ride")
    public ResponseEntity<ReservationRequestDto> bookRide(@RequestBody ReservationRequestDto requestDto){
        requestDto = reservationService.bookRide(requestDto);
        return new ResponseEntity<>(requestDto, HttpStatus.CREATED);
    }
        @GetMapping("/Ride-Info")
        public ResponseEntity<List<ReservationRequestDto>> getAllInfo(){
            List<ReservationRequestDto> rideInfo = reservationService.getAllInfo();
            return new ResponseEntity<>(rideInfo, HttpStatus.OK);
        }
        @GetMapping("/Ride-Info/{userId}")
    public ResponseEntity<List<ReservationRequestDto>> getInfoByUserId(@PathVariable("userId") Long userId){
        List<ReservationRequestDto> rideInfo = reservationService.getInfoById(userId);
        return new ResponseEntity<>(rideInfo, HttpStatus.OK);
    }
}

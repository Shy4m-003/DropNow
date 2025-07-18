package com.scrop.dropnow.controller;

import com.scrop.dropnow.model.DriverCardDto;
import com.scrop.dropnow.model.LocationDto;
import com.scrop.dropnow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/DropNow/user")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/book")
    public ResponseEntity<Map<String, List<DriverCardDto>>> book(@RequestBody LocationDto locationDto) {
        Map<String, List<DriverCardDto>> driverCardMap = bookingService.book(locationDto);
        return ResponseEntity.ok(driverCardMap);
    }
}

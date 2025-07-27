package com.scrop.dropnow.controller;

import com.scrop.dropnow.model.UserCredentialsDto;
import com.scrop.dropnow.model.UserDetailsDto;
import com.scrop.dropnow.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/DropNow/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    @PatchMapping("/edit-details/{userId}")
    public ResponseEntity<UserDetailsDto> addOrUpdateUserDetails(@RequestBody UserDetailsDto dto, @PathVariable Long userId){
        dto = userDetailsService.addOrUpdateUserDetails(dto,userId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PatchMapping("/edit-credentials/{userId}")
    public ResponseEntity<UserCredentialsDto> updateCredentials(@RequestBody UserCredentialsDto dto, @PathVariable Long userId){
        dto = userDetailsService.updateCredentials(dto,userId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/user-info/{userId}")
    public ResponseEntity<UserDetailsDto> getUserInfo(@PathVariable Long userId){
        UserDetailsDto dto = userDetailsService.getUserInfo(userId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}

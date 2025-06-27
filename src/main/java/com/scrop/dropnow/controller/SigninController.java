package com.scrop.dropnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.scrop.dropnow.model.Sign_in;
import com.scrop.dropnow.service.DropService;

import java.util.List;

@RestController
public class SigninController {
	@Autowired
	private DropService dropservice;
	@PostMapping("/Sign-in")
	public ResponseEntity<Sign_in> Create_Account(@RequestBody Sign_in signin) {
		signin = dropservice.Create_Account(signin);
        return new ResponseEntity<>(signin, HttpStatus.CREATED);
	}
	@GetMapping("/Sign-in")
	public ResponseEntity<List<Sign_in>> getAllInfo(){
		List<Sign_in> userList = dropservice.getAllInfo();
        return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	@PutMapping("/Sign-in/{userId}")
	public ResponseEntity<Sign_in> updateUserDetails(@RequestBody Sign_in signIn, @PathVariable Long userId){
		signIn = dropservice.updateUserDetails(signIn,userId);
        return new ResponseEntity<>(signIn, HttpStatus.CREATED);
	}
	@PatchMapping("/Sign-in/Name/{userId}")
	public ResponseEntity<Sign_in> updateName(@RequestBody Sign_in sign_in,@PathVariable long userId){
		sign_in = dropservice.updateName(sign_in,userId);
        return new ResponseEntity<>(sign_in, HttpStatus.OK);
	}
	public ResponseEntity deleteUserDetails(@PathVariable long userId){
		dropservice.deleteUserDetails(userId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		return responseEntity;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

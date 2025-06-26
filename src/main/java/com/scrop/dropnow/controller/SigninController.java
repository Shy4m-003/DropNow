package com.scrop.dropnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.scrop.dropnow.model.Sign_in;
import com.scrop.dropnow.service.DropService;

import java.util.List;

@RestController
public class SigninController {
	@Value("${dn.environment}")
	private String environment;
	@Autowired
	private DropService dropservice;
	@PostMapping("/Sign-in")
	public ResponseEntity<Sign_in> Create_Account(@RequestBody Sign_in signin) {
		signin = dropservice.Create_Account(signin);
		ResponseEntity<Sign_in> responseEntity = new ResponseEntity<>(signin, HttpStatus.CREATED);
		return responseEntity;
	}
	@GetMapping("/Sign-in")
	public ResponseEntity<List<Sign_in>> getAllInfo(){
		System.out.println(environment);
		List<Sign_in> userList = dropservice.getAllInfo();
		ResponseEntity<List<Sign_in>> responseEntity = new ResponseEntity<>(userList,HttpStatus.OK);
		return responseEntity;
	}
	@PutMapping("/Sign-in/{userId}")
	public ResponseEntity<Sign_in> updateUserDetails(@RequestBody Sign_in signIn, @PathVariable Long userId){
		signIn = dropservice.updateUserDetails(signIn,userId);
		ResponseEntity<Sign_in> responseEntity = new ResponseEntity<>(signIn, HttpStatus.CREATED);
		return responseEntity;
	}
	@PatchMapping("/Sign-in/Name/{userId}")
	public ResponseEntity<Sign_in> updateName(@RequestBody Sign_in sign_in,@PathVariable long userId){
		sign_in = dropservice.updateName(sign_in,userId);
		ResponseEntity<Sign_in> responseEntity = new ResponseEntity<>(sign_in, HttpStatus.OK);
		return responseEntity;
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

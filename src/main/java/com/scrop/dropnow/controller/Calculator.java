package com.scrop.dropnow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scrop.dropnow.model.Calculator_dto;

@RestController
public class Calculator {
	@GetMapping("/sum")
	public Double add(Double num1,Double num2) {
		System.out.println("Breakpoint here");
		return num1+num2;
	}
	@GetMapping("/sub")
	public Double sub(double num1,double num2) {
		return num1 - num2;
	}
	@PostMapping("/mul")
	public int mul(@RequestBody Calculator_dto cal) {
		return cal.getNum1() * cal.getNum2();
	}
}

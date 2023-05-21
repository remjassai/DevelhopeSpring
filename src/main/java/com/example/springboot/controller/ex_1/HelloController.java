package com.example.springboot.controller.ex_1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
	@GetMapping(value = "/good-morning")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("Good morning!");
	}

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello coders from around the world!";
	}


	@GetMapping("/greeting")
	public ResponseEntity<String> greet() {
		if(new Date().getHours() < 13){
		return ResponseEntity.badRequest().body("You fool, we are in the morning glory!");
		}
		return ResponseEntity.ok("Good afternoon!");
	}




}

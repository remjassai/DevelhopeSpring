package com.example.springboot.controller.ex_1;

import org.springframework.http.HttpStatus;
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

	//Create a GetMapping that returns a basic "String" as a response
	//1 - Create a new endpoint "/hello" using the @GetMapping annotation.
	//2 - In the method, return a simple string such as "Hello World!".
	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello coders from around the world!";
	}

	//Exercise 2: Create a GetMapping that returns a ResponseEntity as a response
	//1 - Create a new endpoint "/greeting" using the @GetMapping annotation.
	//2 - In the method, return a ResponseEntity object with a string message such as "Good Afternoon!".
	//3 - You can also set the HTTP status code in the ResponseEntity, such as "200 OK".
	@GetMapping("/greeting")
	public ResponseEntity<String> getGreeting() {
/*		if(new Date().getHours() < 13){
		return ResponseEntity.badRequest().body("You fool, we are in the morning glory!");
		}
		return ResponseEntity.ok("Good afternoon!");*/

		String message = "Good morning.";
		return new ResponseEntity<>(message, HttpStatus.OK);

	}
}

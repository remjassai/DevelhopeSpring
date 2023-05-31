package com.example.springboot.controller.ex_1;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    //Exercise 3: Create a new class with a GetMapping that returns a ResponseEntity a
    //1 - Annotate a new class with the @RestController annotation.
    //2 - Create a new endpoint "/info" using the @GetMapping annotation.
    //3 - In the method, return a ResponseEntity with 200 OK
@RestController
public class info {
    @GetMapping("/info")
    public ResponseEntity<String> info(){
        return new ResponseEntity(HttpStatusCode.valueOf(200));
    }

}

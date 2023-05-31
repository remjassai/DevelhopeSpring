package com.example.springboot.controller.ex_1;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


    //Exercise 4: Create a GetMapping that returns 400 - Bad request or 200 - OK based on a random boolean

    //1 - Annotate a new class with the @RestController annotation.
    //2 - Create a new endpoint "/random" using the @GetMapping annotation.
    //3 - In the method, return a ResponseEntity with 200 OK or 400 Bad Request based on the result of new Random().nextBoolean()

    @RestController
    public class random {
        @GetMapping("/random")
        public ResponseEntity random() {
            boolean varNum = new Random().nextBoolean();
            if (varNum) {
                return new ResponseEntity("Your lucky! The value is true!", HttpStatusCode.valueOf(200));
            }
            return new ResponseEntity("You're not so lucky!", HttpStatusCode.valueOf(400));
        }
    }

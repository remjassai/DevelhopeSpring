package com.example.springboot.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
public class random {
    @GetMapping("/random")
    public ResponseEntity random(){
        boolean varNum = new Random().nextBoolean();
       if(varNum){
           return new ResponseEntity("Your lucky! The value is true!",HttpStatusCode.valueOf(200));
       }

       return new ResponseEntity("You're not so lucky!", HttpStatusCode.valueOf(400));
    }
}

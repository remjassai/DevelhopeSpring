package com.example.springboot.controller.ex_1;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class info {
    @GetMapping("/info")
    public ResponseEntity<String> info(){
        return new ResponseEntity(HttpStatusCode.valueOf(200));
    }

}

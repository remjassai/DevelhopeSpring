package com.example.springboot.controller;

import com.example.springboot.component.RestaurantConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {
    private RestaurantConfig restaurantConfig;

    @Autowired
    public RestaurantController(RestaurantConfig restaurantConfig) {
        this.restaurantConfig = restaurantConfig;
    }

    @GetMapping(value = "/get/restaurant-config")
    public ResponseEntity<RestaurantConfig> getRestaurantConfig() {
        return ResponseEntity.ok(restaurantConfig);
    }

    @PutMapping(value = "/put/restaurant-config-min-price/{minPrice}")
    public ResponseEntity<String> updateRestaurantConfigMinPrice(@PathVariable("minPrice") double minPrice) {
        this.restaurantConfig.setMinPrice(minPrice);
        return ResponseEntity.ok("Restaurant config updated!");
    }
}

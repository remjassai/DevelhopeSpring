package com.example.springboot.controller;

import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealController {
    private MealService mealService;
    private RestaurantConfig restaurantConfig;

    @Autowired
    public MealController(MealService mealSevice, RestaurantConfig restaurantConfig) {
        this.mealService = mealSevice;
        this.restaurantConfig = restaurantConfig;
    }

    @PostMapping
    public ResponseEntity<?> createMeal(@RequestBody Meal meal){
        mealService.createMeal(meal);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/get/meals")
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok(mealService.getMeals());
    }

    @GetMapping("/restaurant-config")
    public ResponseEntity<RestaurantConfig> getRestaurantConfig(){
        this.restaurantConfig.setMinPrice(23.00);
        this.restaurantConfig.setTodaysDiscount(2.0);
        return ResponseEntity.ok(restaurantConfig);
    }

    @PostMapping("/post/meal")
    public ResponseEntity<String> addMeal(@RequestBody Meal meal){
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal added!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/meal")
    public ResponseEntity<String> updateMeal(@PathVariable Meal meal){
        mealService.updateMeal(meal);
        return ResponseEntity.ok("Meal updated!");
    }


    @DeleteMapping("/delete/meal/{id}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable long id){
        mealService.deleteMeal(id);
        return ResponseEntity.ok().build();
    }



}

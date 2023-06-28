package com.example.springboot.controller;

import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.model.Ingredient;
import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {
    private MealService mealService;
    private RestaurantConfig restaurantConfig;

    @Autowired
    public MealController(MealService mealService, RestaurantConfig restaurantConfig) {
        this.mealService = mealService;
        this.restaurantConfig = restaurantConfig;
    }

    @PostMapping
    public ResponseEntity<?> createMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
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

    @PutMapping("/update/{mealId}")
    public ResponseEntity<String> updateMeal(@RequestBody Meal meal,@PathVariable long mealId){
        mealService.updateMeal(meal, mealId);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/delete/meal/{id}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable long id){
        mealService.deleteMeal(id);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/insert-meal-test")
//    public ResponseEntity<?> insertMealTest(){
//        mealService.insertMealTest();
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/meal-many-to-one")
    public ResponseEntity<Meal> mealManyToOne(){
        Meal meal = new Meal("Xiaolongabao", "Soup dumplings",10.00,false,true);
        Ingredient ingredient = new Ingredient("Dumpling", true,true,false,true);

        ingredient.setMeal(meal);
        meal.setIngredients(Arrays.asList(ingredient));
        mealService.addMeal(meal);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        mealService.test();
        return ResponseEntity.ok("test");
    }

    @GetMapping("/summer-meals")
    public ResponseEntity<List<Meal>> getSummerMeals(){
        return ResponseEntity.ok(mealService.getSummerMeals());
    }

    @GetMapping("/winter-meals")
    public ResponseEntity<List<Meal>> getWinterMeals(){
        return ResponseEntity.ok(mealService.getWinterMeals());
    }

}

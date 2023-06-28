package com.example.springboot.service;

import com.example.springboot.model.Meal;
import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.dao.MealDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;
    private Double MIN_SUMMER_TEMP = 20.0;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }




    public void addMeal(Meal meal) {
        if (meal == null) throw new IllegalArgumentException("Meal cannot be null!");
        if(meal.getName() == null || meal.getDescription().isEmpty()) throw new IllegalArgumentException("Meal cannot be empty!");
        if(meal.getDescription() == null || meal.getDescription().isEmpty()) throw new IllegalArgumentException("Meal description cannot be empty!");
        if(meal.getPrice() <=0) throw new IllegalArgumentException("Price cannot be less than or equal to 0!");
        mealDao.save(meal);
    }


    public List<Meal> getMeals() {
        return mealDao.findAll();
    }

    public void deleteMeal(long id) {
        mealDao.deleteById(id);
    }

    public void updateMeal(Meal meal, long mealId) {
        mealDao.deleteById(mealId);
        mealDao.save(meal);
    }

    public List<Meal> getSummerMeals() {
        Double currentTemperatureInCentigrade = getCurrentTemperatureInCentigrade();

        if (currentTemperatureInCentigrade < MIN_SUMMER_TEMP) return new ArrayList<>();

        return mealDao.findByIsSummerMeal(true);
    }

    private Double getCurrentTemperatureInCentigrade() {
        try {
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=16.00&longitude=30.0&current_weather=true")
                    .asJson().getBody().getObject();

            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    public void test() {
        mealDao.findByName("Xiaolongbao").forEach(System.out::println);
        System.out.println();
    }

    public List<Meal> getWinterMeals() {
        Double currentTemperatureInCentigrade = getCurrentTemperatureInCentigrade();
        if(currentTemperatureInCentigrade > MIN_SUMMER_TEMP)
            return new ArrayList<>();
        return mealDao.findByIsWinterMeal(true);
    }
}

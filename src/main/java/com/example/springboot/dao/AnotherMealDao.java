package com.example.springboot.dao;

import com.example.springboot.model.Meal;
import com.example.springboot.service.AnotherMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnotherMealDao {
    private List<Meal> myMeals = new ArrayList<>();

    public void addMeal(Meal meal){
        this.myMeals.add(meal);
    }

    public void deleteMeal(String mealName){
        this.myMeals.removeIf(meal-> meal.getName().equals(mealName));
    }

    public void updateMeal(Meal meal){
        this.myMeals.removeIf(m -> m.getName().equals(meal.getName()));
        this.myMeals.add(meal);
    }

    public List<Meal> getMeals() {
        return this.myMeals;
    }

}

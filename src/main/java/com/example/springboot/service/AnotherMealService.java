package com.example.springboot.service;

import com.example.springboot.dao.AnotherMealDao;
import com.example.springboot.model.Meal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotherMealService {
    private AnotherMealDao mealDao;

    public AnotherMealService(AnotherMealDao mealDao){
        this.mealDao = mealDao;
    }

    public void addMeal(Meal meal){
        if(meal == null) throw new IllegalArgumentException("Meal cannot be null!");
        if(meal.getName() == null) throw new IllegalArgumentException("Meal name cannot be null!");
        if(meal.getDescription() == null) throw new IllegalArgumentException("Description cannot be null!");
        if(meal.getPrice() <= 0)throw new IllegalArgumentException("Price cannot be less than or equal to 0!");
        if(meal.getPrice()> 100) throw new IllegalArgumentException("Price exceeds the 100 limit!");
        mealDao.addMeal(meal);
    }

    public void deleteMeal(String mealName){
        mealDao.deleteMeal(mealName);
    }

    public void updateMeal(Meal meal){
        mealDao.updateMeal(meal);
    }

    public List<Meal> getMeals(){
        return mealDao.getMeals();
    }
}

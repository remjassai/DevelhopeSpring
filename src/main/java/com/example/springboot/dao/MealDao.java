package com.example.springboot.dao;

import com.example.springboot.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface MealDao extends JpaRepository<Meal, Long> {
    List<Meal> findByName(String name);
    List<Meal> findByPriceGreaterThanAndName(double price, String name);
    List<Meal> findByIsSummerMeal(boolean isSummerMeal);

    List<Meal> findByDescription(String description);

    List<Meal> findByPriceLessThan(double price);

    List<Meal> findByPriceBetween(double price1, double price2);

    List<Meal> findByDescriptionAndPriceLessThan(String description, double price);

    List<Meal> findByIsWinterMeal(boolean isWinterMeal);


}

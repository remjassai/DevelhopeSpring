package com.example.springboot.dao;

import com.example.springboot.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDao extends JpaRepository<Ingredient, Long> {}

package com.example.springboot.service;

import com.example.springboot.dao.IngredientDao;
import com.example.springboot.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService  {
    private IngredientDao ingredientDao;

    @Autowired
    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientDao.save(ingredient);
    }

    public void addIngredinets(Iterable<Ingredient> ingredients){
        ingredientDao.saveAll(ingredients);
    }

    public void removeIngredient(Ingredient ingredient){
        ingredientDao.delete(ingredient);
    }

    public void removeById(Long id){
        ingredientDao.deleteById(id);
    }

    public void replaceItem(Ingredient ingredient,Long id){
        removeById(id);
        addIngredient(ingredient);
    }

    public Ingredient getIngredientById(Long id){
        //Optional is a container that may contain or not contain the entity
        Optional<Ingredient> optionalIngredient = ingredientDao.findById(id);
        if(optionalIngredient.isPresent()){
            return optionalIngredient.get();
        }
        throw new NullPointerException();
    }
}

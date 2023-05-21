package com.example.springboot.controller.ex_2;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ListController {
    private List<Meal> lista = Arrays.asList(new Meal("Chicken Tikka Massala", "Chicken Tikka Massala id a dish of chunks of roasted marinated chiken in a spiced curry sauce.", 12.99, true),
            new Meal("Chicken Parmesan", "Chicken Parmesan is a dish of chicken cutlet, topped with tomato sauce and melted cheese,baked in the oven.", 11.99, true),
            new Meal("Chicken Fried Steak", "Chicken fried steak is a dish consisting of a breaded and pan-fried cube steak.", 10.99, false),
            new Meal("Chicken and Dumplings", "Chicken and dumplings is a soup or stew of chicken and dumplings.", 9.99, false),
            new Meal("Chicken Pot Pie", "Chicken pot pie is a dish consisting of a pastry crust with a filling of chicken and other vegetables and sometimes gravy.", 8.99, true),
            new Meal("Chicken Cordon Blue", "Chicken Cordon Blue is a dish consisting of a boneless chicken breast pounded thin,wrapped around ham and cheese, and then breaded and pan-fried.", 7.99, false)

    );

    private List<Meal> soupOfTheDay = Arrays.asList(
            new Meal("chicken Noodle Soup", "Chicken noodle soup is a soup made with chicken, chicken broth, and egg noodles.", 6.99, true),
            new Meal("Tomato Soup", "Tomato soup is a soup made from tomatoes, onions, and other vegetables, often served with a grilled cheese sandwich.", 5.99, true),
            new Meal("Clam Chowder", "Clam chowder is a soup made with clams, potatoes, onions, and other vegetables.", 4.99, true),
            new Meal("French Onion Soup", "French onion soup is a soup made with onions, beef broth, and beef stock.", 3.99, false),
            new Meal("Minestrone Soup", "Minestrone soup is a soup made with vegetables, pasta, and beans.", 2.99, true),
            new Meal("Chicken Tortilla Soup", "Chicken tortilla soup is a soup made with chicken, tomatoes, and tortillas.", 1.99, true)
    );

    @GetMapping("/list/{listIndex}")
    public ResponseEntity<Meal> mealList(@PathVariable("listIndex") int listIndex) {
        return ResponseEntity.ok(lista.get(listIndex));
    }

    @GetMapping("/meal/{name}")
    public ResponseEntity<Meal> getSoupOfTheDay(@PathVariable("name") String name) {
        for (Meal meal : soupOfTheDay) {
            if (meal.getName().equalsIgnoreCase(name)) {
                return ResponseEntity.ok(meal);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/meal/description-match/{phrase}")
    public ResponseEntity<List<Meal>> getMealByDescription(@PathVariable("phrase") String phrase){
        List<Meal> matchingMeals = new ArrayList<>();
        for (Meal meal : lista){
            if(meal.getDescription().toLowerCase().contains(phrase.toLowerCase())){
                matchingMeals.add(meal);
            }
        }
        if(!matchingMeals.isEmpty()){
            return ResponseEntity.ok(matchingMeals);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/meal/price")
    public ResponseEntity<List<Meal>> getMealByPriceRange(@RequestParam("min") double minPrice, @RequestParam("max") double maxPrice){
        List<Meal> mealsWithinRange = new ArrayList<>();
        for(Meal meal: soupOfTheDay){
            if(meal.getPrice() >= minPrice && meal.getPrice() <= maxPrice){
                mealsWithinRange.add(meal);
            }
        }
        if(!mealsWithinRange.isEmpty()){
            return ResponseEntity.ok(mealsWithinRange);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}


package com.example.springboot.controller.ex_3;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ex_3")
public class ex_3 {
    private List<Meal> mealsList = new ArrayList<>(Arrays.asList(
            new Meal("Chicken Tikka Massala", "Chicken Tikka Massala id a dish of chunks of roasted marinated chiken in a spiced curry sauce.", 12.99, true),
            new Meal("Chicken Parmesan", "Chicken Parmesan is a dish of chicken cutlet, topped with tomato sauce and melted cheese,baked in the oven.", 11.99, true),
            new Meal("Chicken Fried Steak", "Chicken fried steak is a dish consisting of a breaded and pan-fried cube steak.", 10.99, false),
            new Meal("Chicken and Dumplings", "Chicken and dumplings is a soup or stew of chicken and dumplings.", 9.99, false),
            new Meal("Chicken Pot Pie", "Chicken pot pie is a dish consisting of a pastry crust with a filling of chicken and other vegetables and sometimes gravy.", 8.99, true),
            new Meal("Chicken Cordon Blue", "Chicken Cordon Blue is a dish consisting of a boneless chicken breast pounded thin,wrapped around ham and cheese, and then breaded and pan-fried.", 7.99, false))
    );

    @GetMapping(value = "/getMeals")
    public List<Meal> getMeals(){
        return mealsList;
    }


    //Exercise 1: Create a PostMapping to add a new meal
    // 1 - Create a new endpoint "/meal" using the @PostMapping annotation.
    // 2 - In the method, add a RequestBody for the new Meal object.
    // 3 - Add the new meal to the list of meals.
    @PostMapping(value = "/meal")
    public ResponseEntity<String> postMeal(@RequestBody Meal newMeal){
        this.mealsList.add(newMeal);
        return ResponseEntity.ok("Meal added!");
    }

    //Exercise 2: Create a PutMapping to update a meal by name
    //1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation.
    //2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
    //3 - Update the meal with the corresponding name using the information from the RequestBody.
    @PutMapping("/meal/{name}")
    public ResponseEntity<String> putMeal(@PathVariable String name,@RequestBody Meal newMeal){
        this.mealsList.removeIf(m->m.getName().equalsIgnoreCase(name));
        this.mealsList.add(newMeal);
        return ResponseEntity.ok("Meal updated correctly!");
    }

    //Exercise 3: Create a DeleteMapping to delete a meal by name
    //1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation.
    //2 - In the method, add a PathVariable for the name.
    //3 - Delete the meal with the corresponding name.
    @DeleteMapping("/meal/{name}")
    public ResponseEntity<String> deleteMeal(@PathVariable("name") String name){
        mealsList.removeIf(m->m.getName().equals(name));
        return ResponseEntity.ok("Meal deleted!");
    }


    //Exercise 4: Create a DeleteMapping to delete all meals above a certain price
    //1 - Create a new endpoint "/meal/price/{price}" using the @DeleteMapping annotation.
    //2 - In the method, add a PathVariable for the price.
    //3 - Delete all meals with a price above the price from the PathVariable.
    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteMealsIfPriceAbove(@PathVariable("price") double price){
        this.mealsList.removeIf(m->m.getPrice()>price);
        return ResponseEntity.ok("Meal with price above imputed value deleted!");
    }


    //Exercise 5: Create a PutMapping to update the price of a meal by name
    //1 - Create a new endpoint "/meal/{name}/price" using the @PutMapping annotation.
    //2 - In the method, add a PathVariable for the name and a RequestBody for the updated price.
    //3 - Update the price of the meal with the corresponding name using the information from the RequestBody.
    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> putMealPriceByName(@PathVariable("name") String name,@RequestBody Double newPrice){
        Meal meal = this.mealsList.stream().filter(m->m.getName().equalsIgnoreCase(name)).toList().get(0);
        mealsList.removeIf(m->m.getName().equalsIgnoreCase(name));
        meal.setPrice(newPrice);
        mealsList.add(meal);
        return ResponseEntity.ok("Price updated based on name matching!");
    }

}

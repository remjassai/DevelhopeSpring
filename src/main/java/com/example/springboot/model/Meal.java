package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private static long idTot = 0;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double price;
    @Column
    private boolean isSummerMeal;

    @Column
    private boolean isWinterMeal;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    public Meal(String name, String description, double price, boolean isSummerMeal, boolean isWinterMeal) {
        this.id= ++idTot;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isSummerMeal = isSummerMeal;
        this.isWinterMeal = isWinterMeal;
    }

    public Meal() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public boolean isWinterMeal(){
        return this.isWinterMeal;
    }

    public void setWinterMeal(boolean winterMeal){
        this.isWinterMeal = winterMeal;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isSummerMeal() {
        return isSummerMeal;
    }

    public void setSummerMeal(boolean summerMeal) {
        isSummerMeal = summerMeal;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price;
    }
}

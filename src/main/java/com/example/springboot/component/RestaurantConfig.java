package com.example.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class RestaurantConfig {
    private double minPrice = 5.5;
    private double todaysDiscount = 1.5;

    public RestaurantConfig() {
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getTodaysDiscount() {
        return todaysDiscount;
    }

    public void setTodaysDiscount(double todaysDiscount) {
        this.todaysDiscount = todaysDiscount;
    }
}

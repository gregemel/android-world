package com.emelwerx.world.repository;


import com.emelwerx.world.model.Food;

import java.util.List;

public class FoodRepository {

    public List<Food> getAvailableFood() {
        return availableFood;
    }

    public void setAvailableFood(List<Food> availableFood) {
        this.availableFood = availableFood;
    }

    private List<Food> availableFood;

}

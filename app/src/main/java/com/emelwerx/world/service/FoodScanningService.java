package com.emelwerx.world.service;

import com.emelwerx.world.model.Villager;
import com.emelwerx.world.repository.FoodRepository;

public class FoodScanningService {

    public String Scan(Villager villager, FoodRepository foodRepository) {

        villager.setKnownFood(foodRepository.getAvailableFood());
        return "Scan direction: " + villager;
    }
}

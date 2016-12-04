package com.emelwerx.world.service;

import com.emelwerx.world.model.Villager;
import com.emelwerx.world.model.World;
import com.emelwerx.world.repository.FoodRepository;

public class FoodScanningService {
    public FoodScanningService(World world) {
        this.worldContext = world;
    }

    FoodRepository foodRepository;
    World worldContext;

    public String scan(Villager villager) {
        if (foodRepository == null) {
            foodRepository = (FoodRepository)worldContext.getServiceProvider().getProvider("FoodRepository");
        }
        villager.setKnownFood(foodRepository.getAvailableFood());
        return "Scan direction: " + villager;
    }
}

package com.emelwerx.world.service;


import com.emelwerx.world.model.Food;
import com.emelwerx.world.model.Villager;
import com.emelwerx.world.repository.FoodRepository;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FoodScanningServiceSpec {

    @Test
    public void whenScanningFindsFoodThenAttachCollectionOfKnownFoodToVillager() {
        //setup
        Villager villager = new Villager();
        List<Food> availableFood = new ArrayList<>();
        availableFood.add(new Food());
        FoodRepository foodRepository = new FoodRepository();
        foodRepository.setAvailableFood(availableFood);
        FoodScanningService target = new FoodScanningService();

        //execute
        target.Scan(villager, foodRepository);

        //verify
        Assert.assertEquals(villager.getKnownFood(), availableFood);
    }
}

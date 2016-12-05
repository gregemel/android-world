package com.emelwerx.world.repository;

import com.emelwerx.world.model.Food;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * food repository will need to work against a store, like sql lite
 */

public class FoodRepositorySpec {

    @Test
    public void whenAvailableFoodIsSetThenGetAvailableFood() {
        //setup
        List<Food> availableFood = new ArrayList<>();
        FoodRepository target = new FoodRepository();

        //execute
        target.setAvailableFood(availableFood);

        //verify
        Assert.assertEquals(target.getAvailableFood(), availableFood);
    }
}

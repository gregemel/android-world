package com.emelwerx.world.model;

import junit.framework.Assert;

import org.junit.Test;

/**
 * food contains nutrition
 */

public class FoodSpec {
    @Test
    public void whenNutritionIsSetThenGetReturnsNutrition() {
        //setup
        Food target = new Food();
        int nutrition = 100;

        //execute
        target.setNutrition(nutrition);

        //verify
        Assert.assertEquals(nutrition, target.getNutrition());
    }
}

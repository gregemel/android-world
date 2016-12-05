package com.emelwerx.world.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * villagers are little state containers processed by state-machines
 *
 *     private VillagerMode currentMode;
 *     private ScanDirection currentScanDirection;
 *     private List<Food> knownFood;
 */

public class VillagerSpec {

    private Villager target;

    @Before
    public void givenVillager() {
        target = new Villager();
    }

    @Test
    public void whenVillagerModeIsSetThenGetReturnsVillagerMode() {
        //setup
        VillagerMode mode = VillagerMode.FoodScan;

        //execute
        target.setCurrentMode(mode);

        //verify
        Assert.assertEquals(mode, target.getCurrentMode());
    }

    @Test
    public void whenScanDirectionIsSetThenGetReturnsScanDirection() {
        //setup
        ScanDirection direction = ScanDirection.Forward;

        //execute
        target.setCurrentScanDirection(direction);

        //verify
        Assert.assertEquals(direction, target.getCurrentScanDirection());
    }

    @Test
    public void whenKnownFoodIsSetThenGetReturnsKnownFood() {
        //setup
        List<Food> knownFood = new ArrayList<>();

        //execute
        target.setKnownFood(knownFood);

        //verify
        Assert.assertEquals(knownFood, target.getKnownFood());
    }
}

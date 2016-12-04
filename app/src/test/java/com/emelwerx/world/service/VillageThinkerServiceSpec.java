package com.emelwerx.world.service;

import com.emelwerx.world.model.ScanDirection;
import com.emelwerx.world.model.Villager;
import com.emelwerx.world.model.VillagerMode;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class VillageThinkerServiceSpec {

    private VillageThinkerService target = new VillageThinkerService();

    private Villager villager = new Villager();

    @Before
    public void givenAThinkingVillagerWithNothingToDo() {
        villager.setCurrentMode(VillagerMode.NothingToDo);
        target.think(villager);
    }

    @Test
    public void whenVillagerHasNothingToDoThenSwitchToForageMode() {

        Assert.assertEquals(villager.getCurrentMode(), VillagerMode.Forage);
    }

    @Test
    public void whenVillagerSwitcheToForageThenStartScanningForFood() {

        Assert.assertEquals(villager.getCurrentMode(), VillagerMode.FoodScan);
    }

    @Test
    public void whenSwitchingToScanningForFoodThenStartScanningForward() {

        Assert.assertEquals(villager.getCurrentScanDirection(), ScanDirection.Forward);
    }

    @Test
    public void whenScanningForFoodThenCallFoodScanningService() {


    }
}

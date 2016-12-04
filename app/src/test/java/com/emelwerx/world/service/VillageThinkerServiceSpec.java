package com.emelwerx.world.service;

import com.emelwerx.world.model.Food;
import com.emelwerx.world.model.ScanDirection;
import com.emelwerx.world.model.Villager;
import com.emelwerx.world.model.VillagerMode;
import com.emelwerx.world.repository.FoodRepository;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class VillageThinkerServiceSpec {

    private static final String ENGINE_STARTUP = "Hello from World";

    private VillageThinkerService target;

    private Villager villager = new Villager();

    private FoodRepository foodRepository;

    @Mock
    private FoodScanningService mockFoodScanningService;

    @Before
    public void givenAThinkingVillagerWithNothingToDo() {
        foodRepository = new FoodRepository();
        List<Food> availableFood = new ArrayList<>();
        availableFood.add(new Food());
        foodRepository.setAvailableFood(availableFood);
        mockFoodScanningService = mock(FoodScanningService.class);
        when(mockFoodScanningService.Scan(villager, foodRepository)).thenReturn(ENGINE_STARTUP);
        target = new VillageThinkerService(mockFoodScanningService, foodRepository);
    }

    @Test
    public void whenVillagerHasNothingToDoThenSwitchToForageMode() {
        //setup
        villager.setCurrentMode(VillagerMode.NothingToDo);

        //run
        target.think(villager);

        //verify
        Assert.assertEquals(villager.getCurrentMode(), VillagerMode.Forage);
    }

    @Test
    public void whenVillagerSwitchToForageThenStartScanningForFood() {
        //setup
        villager.setCurrentMode(VillagerMode.Forage);

        //run
        target.think(villager);

        //verify
        Assert.assertEquals(villager.getCurrentMode(), VillagerMode.FoodScan);
    }

    @Test
    public void whenSwitchingToScanningForFoodThenStartScanningForward() {
        //setup
        villager.setCurrentMode(VillagerMode.Forage);

        //run
        target.think(villager);

        //verify
        Assert.assertEquals(villager.getCurrentScanDirection(), ScanDirection.Forward);
    }

    @Test
    public void whenScanningForFoodThenCallFoodScanningService() {
        //setup
        villager.setCurrentMode(VillagerMode.FoodScan);

        //run
        target.think(villager);

        //verify
        verify(mockFoodScanningService, times(1)).Scan(villager, foodRepository);
    }
}

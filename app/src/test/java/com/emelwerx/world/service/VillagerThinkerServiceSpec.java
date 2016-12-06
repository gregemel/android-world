package com.emelwerx.world.service;

import com.emelwerx.world.model.Food;
import com.emelwerx.world.model.ScanDirection;
import com.emelwerx.world.model.Villager;
import com.emelwerx.world.model.VillagerMode;
import com.emelwerx.world.model.World;
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
public class VillagerThinkerServiceSpec {

    private static final String ENGINE_STARTUP = "Hello from World";

    private VillagerThinkerService target;

    private Villager villager = new Villager();

    private FoodRepository foodRepository;

    @Mock
    private WorldServiceProvider mockProvider;

    @Mock
    private FoodScanningService mockFoodScanningService;

    @Before
    public void givenAWorldWithAVillagerWithNothingToDo() {

        World testWorld = new World();
        mockProvider = mock(WorldServiceProvider.class);
        testWorld.setServiceProvider(mockProvider);

        foodRepository = new FoodRepository();
        List<Food> availableFood = new ArrayList<>();
        availableFood.add(new Food());
        foodRepository.setAvailableFood(availableFood);
        when(mockProvider.getProvider("FoodRepository")).thenReturn(foodRepository);

        mockFoodScanningService = mock(FoodScanningService.class);
        when(mockFoodScanningService.scan(villager)).thenReturn(ENGINE_STARTUP);
        when(mockProvider.getProvider("FoodScanner")).thenReturn(mockFoodScanningService);

        target = new VillagerThinkerService(testWorld);
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
        verify(mockFoodScanningService, times(1)).scan(villager);
    }

    public void whenThereIsAvailableFoodNearbyThenMoveTowardsFood() {

    }

    public void whenThereIsAvailableFoodWithinReachThenCollectFood() {

    }

    public void whenCollectingFoodThenFoodCarriedIncreases() {

    }

    public void whenHoldingMaximumFoodThenCarryToNearestStorage() {

    }
}

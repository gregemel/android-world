package com.emelwerx.world.service;


import com.emelwerx.world.model.Food;
import com.emelwerx.world.model.Villager;
import com.emelwerx.world.model.World;
import com.emelwerx.world.repository.FoodRepository;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FoodScanningServiceSpec {

    private World testWorld;

    @Mock
    private WorldServiceProvider mockProvider;

    @Mock
    private FoodRepository mockFoodRepository;

    @Before
    public void givenAWorldWithAProviderService() {
        testWorld = new World();
        mockProvider = mock(WorldServiceProvider.class);
        testWorld.setServiceProvider(mockProvider);

        mockFoodRepository = mock(FoodRepository.class);
        when(mockProvider.getProvider("FoodRepository")).thenReturn(mockFoodRepository);
    }

    @Test
    public void whenScanningFindsFoodThenAttachCollectionOfKnownFoodToVillager() {
        //setup
        Villager villager = new Villager();

        List<Food> availableFood = new ArrayList<>();
        availableFood.add(new Food());
        when(mockFoodRepository.getAvailableFood()).thenReturn(availableFood);

        FoodScanningService target = new FoodScanningService(testWorld);

        //execute
        target.scan(villager);

        //verify
        Assert.assertEquals(villager.getKnownFood(), availableFood);
    }
}

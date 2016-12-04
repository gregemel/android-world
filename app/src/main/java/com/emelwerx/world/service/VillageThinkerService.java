package com.emelwerx.world.service;

import com.emelwerx.world.model.ScanDirection;
import com.emelwerx.world.model.Villager;
import com.emelwerx.world.model.VillagerMode;
import com.emelwerx.world.model.World;
import com.emelwerx.world.repository.FoodRepository;

public class VillageThinkerService {

    private World worldContext;
    private FoodRepository foodRepository;
    private FoodScanningService foodScanningService;

    public VillageThinkerService(World world) {
        worldContext = world;
    }

    public void think(Villager villager) {
        if(villager.getCurrentMode() == VillagerMode.NothingToDo) {
            villager.setCurrentMode(VillagerMode.Forage);
            return;
        }
        if(villager.getCurrentMode() == VillagerMode.Forage) {
            villager.setCurrentMode(VillagerMode.FoodScan);
            villager.setCurrentScanDirection(ScanDirection.Forward);
            return;
        }
        if(villager.getCurrentMode() == VillagerMode.FoodScan) {
            ScanForFood(villager);
        }
    }

    private void ScanForFood(Villager villager) {
        if (foodRepository == null) {
            foodRepository = (FoodRepository)worldContext.getServiceProvider().getProvider("FoodRepository");
        }
        if (foodScanningService == null) {
            foodScanningService = (FoodScanningService)worldContext.getServiceProvider().getProvider("FoodScanner");
        }
        foodScanningService.scan(villager);
    }
}

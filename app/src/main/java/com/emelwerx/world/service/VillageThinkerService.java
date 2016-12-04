package com.emelwerx.world.service;

import com.emelwerx.world.model.ScanDirection;
import com.emelwerx.world.model.Villager;
import com.emelwerx.world.model.VillagerMode;
import com.emelwerx.world.repository.FoodRepository;

public class VillageThinkerService {

    public VillageThinkerService(
            FoodScanningService service,
            FoodRepository foodRepository ) {
        this.foodScanningService = service;
        this.foodRepository = foodRepository;
    }

    /**
     * service dependencies
     */
    private FoodScanningService foodScanningService;
    private FoodRepository foodRepository;

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
        foodScanningService.Scan(villager, foodRepository);
    }
}

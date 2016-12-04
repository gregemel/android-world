package com.emelwerx.world.service;

import com.emelwerx.world.model.ScanDirection;
import com.emelwerx.world.model.Villager;
import com.emelwerx.world.model.VillagerMode;

public class VillageThinkerService {
    public void think(Villager villager) {

        if(villager.getCurrentMode() == VillagerMode.NothingToDo) {
            villager.setCurrentMode(VillagerMode.Forage);
        }
        if(villager.getCurrentMode() == VillagerMode.Forage) {
            villager.setCurrentMode(VillagerMode.FoodScan);
            villager.setCurrentScanDirection(ScanDirection.Forward);
        }
    }
}

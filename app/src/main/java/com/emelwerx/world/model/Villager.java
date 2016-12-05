package com.emelwerx.world.model;

import java.util.List;

public class Villager {
    private VillagerMode currentMode;
    private ScanDirection currentScanDirection;
    private List<Food> knownFood;

    public VillagerMode getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(final VillagerMode currentMode) {
        this.currentMode = currentMode;
    }

    public ScanDirection getCurrentScanDirection() {
        return currentScanDirection;
    }

    public void setCurrentScanDirection(final ScanDirection currentScanDirection) {
        this.currentScanDirection = currentScanDirection;
    }

    public List<Food> getKnownFood() {
        return knownFood;
    }

    public void setKnownFood(final List<Food> knownFood) {
        this.knownFood = knownFood;
    }
}

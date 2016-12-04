package com.emelwerx.world.model;


import java.util.List;

public class Villager {
    public VillagerMode getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(final VillagerMode currentMode) {
        this.currentMode = currentMode;
    }

    private VillagerMode currentMode;

    public ScanDirection getCurrentScanDirection() {
        return currentScanDirection;
    }

    public void setCurrentScanDirection(final ScanDirection currentScanDirection) {
        this.currentScanDirection = currentScanDirection;
    }

    private ScanDirection currentScanDirection;

    public List<Food> getKnownFood() {
        return knownFood;
    }

    public void setKnownFood(final List<Food> knownFood) {
        this.knownFood = knownFood;
    }

    private List<Food> knownFood;
}

package com.emelwerx.world.model;


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
}

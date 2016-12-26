package com.emelwerx.world.model;


public class Location {
    public Location() {
        x = 0;
        y = 0;
        z = 0;
    }
    public Location(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    private float x;

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float y;
    private float z;

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}

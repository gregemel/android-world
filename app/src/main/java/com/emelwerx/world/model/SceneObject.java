package com.emelwerx.world.model;

/**
 * something that can be moved within the game scene
 */

public class SceneObject {


    private Location location;
    private Velocity velocity;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }
}

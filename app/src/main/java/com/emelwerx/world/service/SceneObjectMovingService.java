package com.emelwerx.world.service;

import com.emelwerx.world.model.SceneObject;

import java.util.List;

/**
 * service moves objects based on current velocity
 */

public class SceneObjectMovingService {
    public void move(long deltaTime, List<SceneObject> sceneObjects) {
        for (SceneObject sceneObject : sceneObjects) {
            sceneObject.getLocation().setX(
                    sceneObject.getLocation().getX()
                    + (sceneObject.getVelocity().getX() * deltaTime));
            sceneObject.getLocation().setY(
                    sceneObject.getLocation().getY()
                            + (sceneObject.getVelocity().getY() * deltaTime));
            sceneObject.getLocation().setZ(
                    sceneObject.getLocation().getZ()
                            + (sceneObject.getVelocity().getZ() * deltaTime));
        }
    }
}

package com.emelwerx.world.service;

import com.emelwerx.world.model.Location;
import com.emelwerx.world.model.SceneObject;
import com.emelwerx.world.model.Velocity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * tests for SceneObjectMovingService
 */

public class SceneObjectMovingServiceSpec {

    private SceneObjectMovingService target;

    @Before
    public void setUp() throws Exception {

        target = new SceneObjectMovingService();

    }

    @Test
    public void whenMoveThenEachObjectHasVelocityAppliedToLocation() {
        List<SceneObject> sceneObjects = PopulateTestSceneObjects();

        long deltaTime = 5;
        sceneObjects.get(0).setVelocity(new Velocity(4, 5, 6));
        sceneObjects.get(0).setLocation(new Location(0, 0, 0));

        sceneObjects.get(1).setVelocity(new Velocity(4, 0, 0));
        sceneObjects.get(1).setLocation(new Location(0, 0, 0));

        target.move(deltaTime, sceneObjects);

        Assert.assertEquals(sceneObjects.get(0).getLocation().getX(), 20.0f);
        Assert.assertEquals(sceneObjects.get(0).getLocation().getY(), 25.0f);
        Assert.assertEquals(sceneObjects.get(0).getLocation().getZ(), 30.0f);

        Assert.assertEquals(sceneObjects.get(1).getLocation().getX(), 20.0f);
    }

    private List<SceneObject> PopulateTestSceneObjects() {
        List<SceneObject> sceneObjects = new ArrayList<>();

        SceneObject object1 = new SceneObject();

        SceneObject object2 = new SceneObject();

        sceneObjects.add(object1);
        sceneObjects.add(object2);

        return sceneObjects;
    }
}

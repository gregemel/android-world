package com.emelwerx.world.service;

import com.emelwerx.world.model.World;

import junit.framework.Assert;

import org.junit.Test;

/**
 * creates a new, empty world
 */

public class WorldBootServiceSpec {

    private WorldServiceProvider serviceProvider = new WorldServiceProvider();
    private WorldBootService target = new WorldBootService(serviceProvider);

    @Test
    public void whenCreateThenWorldIsCreatedWithAProviderService() {

        //execute
        World world = target.createNew();

        Assert.assertEquals(world.getServiceProvider(), serviceProvider);
    }

    @Test
    public void whenCreateThenProviderHasFoodRepository() {
        //execute
        World world = target.createNew();

        Assert.assertNotNull(world.getServiceProvider().getProvider("FoodRepository"));
    }

    @Test
    public void whenCreateThenProviderHasFoodScannerService() {
        //execute
        World world = target.createNew();

        Assert.assertNotNull(world.getServiceProvider().getProvider("FoodScanner"));
    }
}

package com.emelwerx.world.model;

import com.emelwerx.world.service.WorldServiceProvider;

import junit.framework.Assert;

import org.junit.Test;

/**
 * world is root container for all things in a world instance
 * holds a service provider, for now
 */

public class WorldSpec {
    @Test
    public void whenWorldServiceProviderIsSetThenGetReturnsWorldServiceProvider() {
        //setup
        WorldServiceProvider provider = new WorldServiceProvider();
        World target = new World();

        //execute
        target.setServiceProvider(provider);

        //verify
        Assert.assertEquals(target.getServiceProvider(), provider);
    }
}

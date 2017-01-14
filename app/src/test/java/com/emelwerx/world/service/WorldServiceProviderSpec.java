package com.emelwerx.world.service;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * service provider provides domain services using name/object pairings
 * probably should replace with Spring @Autowire
 */

public class WorldServiceProviderSpec {

    private Map<String, Object> map = new HashMap<>();

    private WorldServiceProvider target;

    @Before
    public void givenServiceProviderAndMap() {
        target = new WorldServiceProvider();
    }

    @Test
    public void whenTheProviderMapIsLoadedThenVillageThinkerIsAvailable() {
        //setup
        String serviceName = "service1";
        Object object = new Object();
        map.put(serviceName, object);
        target.setServicesMap(map);

        //execute
        Object service = target.getProvider(serviceName);

        //verify
        Assert.assertEquals(service, object);
   }
}

package com.emelwerx.world.model;

import com.emelwerx.world.service.WorldServiceProvider;

/**
 * world container object
 */

public class World {
    private WorldServiceProvider serviceProvider;

    public WorldServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(WorldServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}

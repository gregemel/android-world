package com.emelwerx.world.service;

import java.util.Map;

/**
 * provides services to the world
 * this should probably be replace with something like spring autowire
 */

public class WorldServiceProvider {

    private Map<String, Object> servicesMap;

    public void setServicesMap(final Map<String, Object> servicesMap) {
        this.servicesMap = servicesMap;
    }

    public Object getProvider(String key) {
        return servicesMap.get(key);
    }
}

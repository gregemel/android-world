package com.emelwerx.world.service;

import java.util.Map;

/**
 * provides services to the world
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

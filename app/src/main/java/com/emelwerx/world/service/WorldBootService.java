package com.emelwerx.world.service;

import com.emelwerx.world.model.World;
import com.emelwerx.world.repository.FoodRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * world boot: starts a world with service provider
 */

public class WorldBootService {
    private WorldServiceProvider serviceProvider;

    public WorldBootService(WorldServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public World createNew() {
        World world = new World();
        Map<String, Object> serviceProviderMap = new HashMap<>();
        serviceProviderMap.put("FoodRepository", new FoodRepository());
        serviceProviderMap.put("FoodScanner", new FoodScanningService(world));
        //serviceProviderMap.put("VillageThinker", new VillageThinkerService());
        serviceProvider.setServicesMap(serviceProviderMap);
        world.setServiceProvider(serviceProvider);
        return world;
    }
}

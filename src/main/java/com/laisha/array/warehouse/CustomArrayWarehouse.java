package com.laisha.array.warehouse;

import com.laisha.array.entity.CustomArrayStatistics;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CustomArrayWarehouse {

    private static final CustomArrayWarehouse instance = new CustomArrayWarehouse();
    private final Map<UUID, CustomArrayStatistics> warehouse = new HashMap<>();

    private CustomArrayWarehouse() {
    }

    public static CustomArrayWarehouse getInstance() {
        return instance;
    }

    public void put(UUID key, CustomArrayStatistics value) {
        warehouse.put(key, value);
    }

    public void remove(UUID key) {
        warehouse.remove(key);
    }

    public CustomArrayStatistics get(UUID key) {
        return warehouse.get(key);
    }

    public void replace(UUID key, CustomArrayStatistics value) {
        warehouse.replace(key, value);
    }

    public int size() {
        return warehouse.size();
    }
}

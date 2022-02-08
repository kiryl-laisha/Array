package com.laisha.array.warehouse;

import com.laisha.array.entity.UserArrayStatistics;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserArrayWarehouse {

    private static final UserArrayWarehouse instance = new UserArrayWarehouse();
    private final Map<UUID, UserArrayStatistics> warehouse = new HashMap<>();

    private UserArrayWarehouse() {
    }

    public static UserArrayWarehouse getInstance() {
        return instance;
    }

    public void put(UUID key, UserArrayStatistics value) {
        warehouse.put(key, value);
    }

    public void remove(UUID key) {
        warehouse.remove(key);
    }

    public UserArrayStatistics get(UUID key) {
        return warehouse.get(key);
    }

    public void replace(UUID key, UserArrayStatistics value) {
        warehouse.replace(key, value);
    }

    public int size() {
        return warehouse.size();
    }
}

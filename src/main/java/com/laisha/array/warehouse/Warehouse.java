package com.laisha.array.warehouse;

import com.laisha.array.entity.IntegerArrayStatistics;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Warehouse {

    private static final Warehouse instance = new Warehouse();
    private Map<UUID, IntegerArrayStatistics> warehouse = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public IntegerArrayStatistics put(UUID key, IntegerArrayStatistics value) {
        return warehouse.put(key, value);
    }

    public IntegerArrayStatistics remove(Object key) {
        return warehouse.remove(key);
    }

    public IntegerArrayStatistics get(UUID key) {
        return warehouse.get(key);
    }

    public IntegerArrayStatistics replace(UUID key, IntegerArrayStatistics value) {
        return warehouse.replace(key, value);
    }
}

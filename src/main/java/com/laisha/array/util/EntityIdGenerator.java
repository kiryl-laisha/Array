package com.laisha.array.util;

import java.util.UUID;

public class EntityIdGenerator {

    private EntityIdGenerator() {
    }

    public static UUID generateEntityId() {
        return UUID.randomUUID();
    }
}

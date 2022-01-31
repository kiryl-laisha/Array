package com.laisha.array.util;

import org.junit.jupiter.api.RepeatedTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EntityIdGeneratorTest {

    private static final String REGEX_STRING_AS_UUID = "^[\\da-fA-F]{8}-[\\da-fA-F]{4}" +
            "-4[\\da-fA-F]{3}-[8-9abAB][\\da-fA-F]{3}-[\\da-fA-F]{12}$";

    @RepeatedTest(10)
    void generateUniqueEntityId() {

        UUID entityId = EntityIdGenerator.generateEntityId();
        assertTrue(entityId.toString().matches(REGEX_STRING_AS_UUID));
    }
}
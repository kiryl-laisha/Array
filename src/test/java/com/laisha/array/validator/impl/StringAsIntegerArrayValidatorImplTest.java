package com.laisha.array.validator.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringAsIntegerArrayValidatorImplTest {

    private static StringAsIntegerArrayValidatorImpl stringAsIntegerArrayValidator =
            StringAsIntegerArrayValidatorImpl.getInstance();

    @AfterAll
    static void tearDownClass() {

        stringAsIntegerArrayValidator = null;
    }

    @ParameterizedTest
    @DisplayName("Valid strings are provided.")
    @ValueSource(strings = {"+5 2147483647 -1230 45321 23123123 -77777",
            "  2        21 -130    45321 23123 -77   7 \t\r\n   ",
            "0 5   -5 "})
    void validateStringAsIntegerArrayPositiveTest(String stringAsArray) {

        boolean isValidStringAsIntegerArray =
                stringAsIntegerArrayValidator.validateStringAsArray(stringAsArray);
        assertTrue(isValidStringAsIntegerArray);
    }

    @ParameterizedTest
    @DisplayName("Invalid strings and null and empty string are provided.")
    @NullAndEmptySource
    @ValueSource(strings = {"5 -1230 45321 -2147483649 +77777",
            "The text string!",
            " 5 23423 -964 7. 90",
            "5 1b -964 56 90",
            "a"})
    void validateStringAsIntegerArrayNegativeTest(String stringAsArray) {

        boolean isValidStringAsIntegerArray =
                stringAsIntegerArrayValidator.validateStringAsArray(stringAsArray);
        assertFalse(isValidStringAsIntegerArray);
    }
}

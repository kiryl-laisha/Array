package com.laisha.array.validator.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringAsIntegerArrayValidatorImplTest {

    private static StringAsIntegerArrayValidatorImpl stringAsIntegerArrayValidator =
            StringAsIntegerArrayValidatorImpl.getInstance();

    @Test
    public void validateValidStringAsIntegerArray() {

        String validStringAsIntegerArray = "+5 2147483647 -1230 45321 23123123 -77777";
        boolean isValidStringAsIntegerArray =
                stringAsIntegerArrayValidator.validateStringAsArray(validStringAsIntegerArray);
        assertTrue(isValidStringAsIntegerArray);
    }

    @Test
    public void validateStringWithOutOfBoundsNumbersAsIntegerArray() {

        String validStringAsIntegerArray = "5 -1230 45321 -2147483649 +77777";
        boolean isValidStringAsIntegerArray =
                stringAsIntegerArrayValidator.validateStringAsArray(validStringAsIntegerArray);
        assertFalse(isValidStringAsIntegerArray);
    }

    @Test
    public void validateNullStringAsIntegerArray() {

        String validStringAsIntegerArray = null;
        boolean isValidStringAsIntegerArray =
                stringAsIntegerArrayValidator.validateStringAsArray(validStringAsIntegerArray);
        assertFalse(isValidStringAsIntegerArray);
    }

    @Test
    public void validateTextContainingStringAsIntegerArray() {

        String validStringAsIntegerArray = "The text string!";
        boolean isValidStringAsIntegerArray =
                stringAsIntegerArrayValidator.validateStringAsArray(validStringAsIntegerArray);
        assertFalse(isValidStringAsIntegerArray);
    }

    @Test
    public void validateDoubleContainingStringAsIntegerArray() {

        String validStringAsIntegerArray = "5 23423 -964 7. 90";
        boolean isValidStringAsIntegerArray =
                stringAsIntegerArrayValidator.validateStringAsArray(validStringAsIntegerArray);
        assertFalse(isValidStringAsIntegerArray);
    }

    @Test
    public void validateLetterContainingStringAsIntegerArray() {

        String validStringAsIntegerArray = "5 1b -964 56 90";
        boolean isValidStringAsIntegerArray =
                stringAsIntegerArrayValidator.validateStringAsArray(validStringAsIntegerArray);
        assertFalse(isValidStringAsIntegerArray);
    }
}

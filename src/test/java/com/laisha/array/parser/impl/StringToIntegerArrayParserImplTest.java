package com.laisha.array.parser.impl;

import com.laisha.array.exception.ProjectException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToIntegerArrayParserImplTest {

    private static StringToIntegerArrayParserImpl stringParser =
            StringToIntegerArrayParserImpl.getInstance();
    private static String actualExceptionMessage;
    private static String expectedExceptionMessage;

    @BeforeEach
    void setUp() {

        actualExceptionMessage = null;
        expectedExceptionMessage = null;
    }

    @AfterAll
    static void tearDownClass() {

        actualExceptionMessage = null;
        expectedExceptionMessage = null;
        stringParser = null;
    }

    @ParameterizedTest
    @DisplayName("Valid string is provided.")
    @ValueSource(strings = {"5 -5   19  2022 "})
    void parseStringToIntegerArrayPositiveTest(String stringAsIntegerArray)
            throws ProjectException {

        int[] expected = new int[]{5, -5, 19, 2022};
        int[] actual = stringParser.parseStringToIntegerArray(stringAsIntegerArray);
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Invalid strings are provided.")
    @ValueSource(strings = {"5 -1230 45321 -2147483649 +77777",
            " 5 23423 -964 7. 90",
            "5 1b -964 56 90",
            "a"})
    void parseStringToIntegerArrayFirstNegativeTest(String stringAsIntegerArray) {

        expectedExceptionMessage = "The provided string \"" + stringAsIntegerArray +
                "\" is not valid as integer array.";
        try {
            stringParser.parseStringToIntegerArray(stringAsIntegerArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @DisplayName("Null is provided.")
    @NullSource
    void parseStringToIntegerArraySecondNegativeTest(String stringAsIntegerArray) {

        expectedExceptionMessage = "The provided string is null.";
        try {
            stringParser.parseStringToIntegerArray(stringAsIntegerArray);
        } catch (ProjectException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @DisplayName("Empty string and string with whitespaces are provided.")
    @EmptySource
    @ValueSource(strings = {"    \t\r\n \f ",
            "        "})
    void parseStringToIntegerArraySecondPositiveTest(String stringAsIntegerArray)
            throws ProjectException {

        int[] expected = {};
        int[] actual = stringParser.parseStringToIntegerArray(stringAsIntegerArray);
        assertArrayEquals(expected, actual);
    }
}

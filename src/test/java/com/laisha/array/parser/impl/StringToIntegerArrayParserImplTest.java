package com.laisha.array.parser.impl;

import com.laisha.array.exception.ProjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToIntegerArrayParserImplTest {

    private static final StringToIntegerArrayParserImpl stringToIntegerArrayParser =
            StringToIntegerArrayParserImpl.getInstance();
    private static String actualExceptionMessage;

    @BeforeEach
    void setUp() {
        actualExceptionMessage = null;
    }

    @Test
    public void parseStringToIntegerArray() throws ProjectException {

        String stringAsIntegerArray = "5 -5   19  2022 ";
        int[] expected = new int[]{5, -5, 19, 2022};
        int[] actual = stringToIntegerArrayParser
                .parseStringToIntegerArray(stringAsIntegerArray);
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 -1230 45321 -2147483649 +77777",
            " 5 23423 -964 7. 90",
            "5 1b -964 56 90"})
    public void parseInvalidStringToIntegerArray(String stringAsIntegerArray) {

        String expectedExceptionMessage = "The provided string \"" + stringAsIntegerArray +
                "\" is not valid as integer array.";
        try {
            stringToIntegerArrayParser.parseStringToIntegerArray(stringAsIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }

    @ParameterizedTest
    @NullSource
    public void parseNullToIntegerArray(String stringAsIntegerArray) {

        String expectedExceptionMessage = "The provided string is null.";
        try {
            stringToIntegerArrayParser.parseStringToIntegerArray(stringAsIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }

    @ParameterizedTest
    @EmptySource
    public void parseEmptyStringToIntegerArray(String stringAsIntegerArray) {

        String expectedExceptionMessage = "The provided string is empty or " +
                "contains only white space codepoints.";
        try {
            stringToIntegerArrayParser.parseStringToIntegerArray(stringAsIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }

    @Test
    public void parseNoElementStringToIntegerArray() {

        String stringAsIntegerArray = "    \t\r\n \f ";
        String expectedExceptionMessage = "The provided string is empty or " +
                "contains only white space codepoints.";
        try {
            stringToIntegerArrayParser.parseStringToIntegerArray(stringAsIntegerArray);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        assertEquals(actualExceptionMessage, expectedExceptionMessage);
    }
}

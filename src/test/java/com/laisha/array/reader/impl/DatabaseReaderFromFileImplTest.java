package com.laisha.array.reader.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class DatabaseReaderFromFileImplTest {

    static final String TEST_FILE_PATH = "data\\test_data_arrays.txt";
    static final String TEST_DEFAULT_FILE_PATH = "data\\test_default_data_arrays.txt";
    static final String TEST_NOT_EXIST_FILE_PATH = "data\\test_not_exist_data_arrays.txt";
    static final String TEST_EMPTY_FILE_PATH = "data/test_empty_file.txt";
    static DataBaseReaderFromFileImpl readerFromFile = DataBaseReaderFromFileImpl.getInstance();
    static List<String> expectedStringList;
    static List<String> actualStringList;

    @BeforeEach
    void setUp() {

        expectedStringList = new ArrayList<>();
        actualStringList = new ArrayList<>();
    }

    @AfterAll
    static void tearDownClass() {

        readerFromFile = null;
        expectedStringList = null;
        actualStringList = null;
    }

    @ParameterizedTest
    @DisplayName("File path is valid, default file path using is false or true.")
    @ValueSource(booleans = {true, false})
    void readStringListFromFileFirstPositiveTest(boolean defaultFileUsing) {

        expectedStringList.add("1 -1 56");
        expectedStringList.add("-2 2 100");
        actualStringList = readerFromFile.readStringListFromFile(TEST_FILE_PATH, defaultFileUsing);
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @ParameterizedTest
    @DisplayName("File path is null or empty or not exist, default file path using is false.")
    @NullAndEmptySource
    @ValueSource(strings = {TEST_NOT_EXIST_FILE_PATH, "12.txt"})
    void readStringListFromFileFirstNegativeTest(String filepath) {

        String expectedExceptionMessage = "Database cannot be loaded from file.";
        String actualExceptionMessage = null;
        try {
            readerFromFile.readStringListFromFile(filepath, false);
        } catch (RuntimeException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @DisplayName("File path is null or empty or not exist, default file path is valid, " +
            "default file path using is true.")
    @NullAndEmptySource
    @ValueSource(strings = {TEST_NOT_EXIST_FILE_PATH, "12.txt"})
    void readStringListFromFileSecondPositiveTest(String filepath) {

        expectedStringList.add("5 -5    0");
        expectedStringList.add("3 1 3");
        expectedStringList.add("-117   5 139");
        DataBaseReaderFromFileImpl.defaultFilePath = TEST_DEFAULT_FILE_PATH;
        actualStringList = readerFromFile.readStringListFromFile(filepath, true);
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @ParameterizedTest
    @DisplayName("Both file path and default file path are null or empty " +
            "or not exist, default file path using is true.")
    @NullAndEmptySource
    @ValueSource(strings = {TEST_NOT_EXIST_FILE_PATH, "12.txt"})
    void readStringListFromFileSecondNegativeTest(String filepath) {

        String expectedExceptionMessage = "Database cannot be loaded from files.";
        String actualExceptionMessage = null;
        DataBaseReaderFromFileImpl.defaultFilePath = filepath;
        try {
            readerFromFile.readStringListFromFile(filepath, true);
        } catch (RuntimeException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @ParameterizedTest
    @DisplayName("Both file path and default file path are empty, " +
            "default file path using is true or false.")
    @ValueSource(booleans = {true, false})
    void readStringListFromFileThirdNegativeTest(boolean defaultFileUsing) {

        String expectedExceptionMessage = "File \"" + TEST_EMPTY_FILE_PATH + "\" " +
                "is empty. Database cannot be loaded.";
        String actualExceptionMessage = null;
        DataBaseReaderFromFileImpl.defaultFilePath = TEST_EMPTY_FILE_PATH;
        try {
            readerFromFile.readStringListFromFile(TEST_EMPTY_FILE_PATH, defaultFileUsing);
        } catch (RuntimeException e) {
            actualExceptionMessage = e.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }
}
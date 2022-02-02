package com.laisha.array.reader.impl;

import com.laisha.array.exception.ProjectException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class SimpleReaderFromFileImplTest {

    static final String TEST_FILE_PATH = "data\\test_data_arrays.txt";
    static final String TEST_DEFAULT_FILE_PATH = "data\\test_default_data_arrays.txt";
    static final String TEST_NOT_EXIST_FILE_PATH = "data\\test_not_exist_data_arrays.txt";
    static SimpleReaderFromFileImpl readerFromFile = SimpleReaderFromFileImpl.getInstance();
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

    @Test
    public void readStringListFromProvidedValidFileWithDefaultFileUsingIsFalseTest()
            throws ProjectException {

        actualStringList = readerFromFile.readListStringFromFile(TEST_FILE_PATH, false);
        expectedStringList.add("1 -1 56");
        expectedStringList.add("-2 2 100");
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @Test
    public void readStringListFromProvidedValidFileWithDefaultFileUsingIsTrueTest() throws ProjectException {

        actualStringList = readerFromFile.readListStringFromFile(TEST_FILE_PATH, true);
        expectedStringList.add("1 -1 56");
        expectedStringList.add("-2 2 100");
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @Test
    public void readStringListFromNullProvidedFileWithDefaultFileUsingIsFalseTest() {

        String actualExceptionMessage = null;
        String expectedExceptionMessage = "Reading from the file for the file path "
                + null + " is not available.";
        try {
            actualStringList = readerFromFile.readListStringFromFile(null, false);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void readStringListFromNullProvidedFileWithDefaultFileUsingIsTrueTest() throws ProjectException {

        expectedStringList.add("5 -5 0");
        expectedStringList.add("3 1 3");
        expectedStringList.add("-117 5 139");
        readerFromFile.setDefaultFilePath(TEST_DEFAULT_FILE_PATH);
        actualStringList = readerFromFile.readListStringFromFile(null, true);
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @Test
    public void readStringListFromNotExistProvidedFileWithDefaultFileUsingIsFalseTest() {

        String actualExceptionMessage = null;
        String expectedExceptionMessage = "Reading from the file for the file path "
                + TEST_NOT_EXIST_FILE_PATH + " is not available.";
        try {
            actualStringList = readerFromFile.readListStringFromFile(TEST_NOT_EXIST_FILE_PATH, false);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void readStringListFromNotExistProvidedFileWithDefaultFileUsingIsTrueTest() throws ProjectException {

        expectedStringList.add("5 -5 0");
        expectedStringList.add("3 1 3");
        expectedStringList.add("-117 5 139");
        readerFromFile.setDefaultFilePath(TEST_DEFAULT_FILE_PATH);
        actualStringList = readerFromFile.readListStringFromFile(TEST_NOT_EXIST_FILE_PATH, true);
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @Test
    public void readStringListFromNotExistProvidedFileWithDefaultFileUsingIsTrueAndNullDefaultFileTest() {

        readerFromFile.setDefaultFilePath(null);
        String actualExceptionMessage = null;
        String expectedExceptionMessage = "Reading from the files (both provided and default) " +
                "is not possible.";
        try {
            actualStringList = readerFromFile.readListStringFromFile(TEST_NOT_EXIST_FILE_PATH, true);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void readStringListFromNullProvidedFileWithDefaultFileUsingIsTrueAndNotExistDefaultFileTest() {

        readerFromFile.setDefaultFilePath(TEST_NOT_EXIST_FILE_PATH);
        String actualExceptionMessage = null;
        String expectedExceptionMessage = "Reading from the files (both provided and default) " +
                "is not possible.";
        try {
            actualStringList = readerFromFile.readListStringFromFile(null, true);
        } catch (ProjectException projectException) {
            actualExceptionMessage = projectException.getMessage();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void setDefaultFilePathTest() {

        readerFromFile.setDefaultFilePath(TEST_FILE_PATH);
        String actualDefaultFilePath = readerFromFile.getDefaultFilePath();
        String expectedDefaultFilePath = TEST_FILE_PATH;
        assertEquals(expectedDefaultFilePath, actualDefaultFilePath);
    }
}
package com.laisha.array.reader.impl;

import com.laisha.array.exception.ProjectException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ReaderFromFileImplTest {

    static final String TEST_FILE_PATH = "data\\test_data_arrays.txt";
    static final String TEST_DEFAULT_FILE_PATH = "data\\test_default_data_arrays.txt";
    static final String TEST_NOT_EXIST_FILE_PATH = "data\\test_not_exist_data_arrays.txt";
    static ReaderFromFileImpl readerFromFile = ReaderFromFileImpl.getInstance();
    static List<String> expectedStringList;
    static List<String> actualStringList;

    @AfterAll
    static void tearDown() {
        readerFromFile = null;
    }

    @BeforeEach
    void setUp() {
        expectedStringList = new ArrayList<>();
        actualStringList = new ArrayList<>();
    }

    @Test
    void readStringListFromProvidedValidFileWithDefaultFileUsingIsFalseTest()
            throws ProjectException {

        actualStringList = readerFromFile.readListStringFromFile(TEST_FILE_PATH, false);
        expectedStringList.add("1 -1 56");
        expectedStringList.add("-2 2 100");
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @Test
    void readStringListFromProvidedValidFileWithDefaultFileUsingIsTrueTest() throws ProjectException {

        actualStringList = readerFromFile.readListStringFromFile(TEST_FILE_PATH, true);
        expectedStringList.add("1 -1 56");
        expectedStringList.add("-2 2 100");
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @Test
    void readStringListFromNullProvidedFileWithDefaultFileUsingIsFalseTest(){

        readerFromFile.setDefaultFilePath(TEST_DEFAULT_FILE_PATH);
        assertThrowsExactly(RuntimeException.class,
                () -> readerFromFile.readListStringFromFile(null, false));
    }

    @Test
    void readStringListFromNullProvidedFileWithDefaultFileUsingIsTrueTest() throws ProjectException {

        expectedStringList.add("5 -5 0");
        expectedStringList.add("3 1 3");
        expectedStringList.add("-117 5 139");
        readerFromFile.setDefaultFilePath(TEST_DEFAULT_FILE_PATH);
        actualStringList = readerFromFile.readListStringFromFile(null, true);
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @Test
    void readStringListFromNotExistProvidedFileWithDefaultFileUsingIsFalseTest(){

        readerFromFile.setDefaultFilePath(TEST_DEFAULT_FILE_PATH);
        assertThrowsExactly(RuntimeException.class,
                () -> readerFromFile.readListStringFromFile(TEST_NOT_EXIST_FILE_PATH, false));
    }

    @Test
    void readStringListFromNotExistProvidedFileWithDefaultFileUsingIsTrueTest() throws ProjectException {

        expectedStringList.add("5 -5 0");
        expectedStringList.add("3 1 3");
        expectedStringList.add("-117 5 139");
        readerFromFile.setDefaultFilePath(TEST_DEFAULT_FILE_PATH);
        actualStringList = readerFromFile.readListStringFromFile(TEST_NOT_EXIST_FILE_PATH, true);
        assertLinesMatch(expectedStringList, actualStringList);
    }

    @Test
    void readStringListFromNotExistProvidedFileWithDefaultFileUsingIsTrueAndNullDefaultFileTest(){

        readerFromFile.setDefaultFilePath(null);
        assertThrowsExactly(RuntimeException.class,
                () -> readerFromFile.readListStringFromFile(TEST_NOT_EXIST_FILE_PATH, true));
    }

    @Test
    void readStringListFromNullProvidedFileWithDefaultFileUsingIsTrueAndNotExistDefaultFileTest(){

        readerFromFile.setDefaultFilePath(TEST_NOT_EXIST_FILE_PATH);
        assertThrowsExactly(RuntimeException.class,
                () -> readerFromFile.readListStringFromFile(null, true));
    }
}
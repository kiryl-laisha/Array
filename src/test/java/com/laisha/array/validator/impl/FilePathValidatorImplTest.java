package com.laisha.array.validator.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathValidatorImplTest {

    private static FilePathValidatorImpl filePathValidator = FilePathValidatorImpl.getInstance();

    @AfterAll
    static void tearDownClass() {

        filePathValidator = null;
    }

    @Test
    public void validateExistFilePathTest() {

        String validFilePath = "data/validator_data/valid_file.txt";
        boolean isValidFilePath = filePathValidator.validateFilePath(validFilePath);
        assertTrue(isValidFilePath);
    }

    @Test
    public void validateNotExistFilePathTest() {

        String invalidFilePath = "data/validator_data/file.txt";
        boolean isValidFilePath = filePathValidator.validateFilePath(invalidFilePath);
        assertFalse(isValidFilePath);
    }

    @Test
    public void validateNullFilePathTest() {

        boolean isValidFilePath = filePathValidator.validateFilePath(null);
        assertFalse(isValidFilePath);
    }

    @Test
    public void validateExistFilePathWithEmptyFileTest() {

        String validFilePath = "data/validator_data/empty_file.txt";
        boolean isValidFilePath = filePathValidator.validateFilePath(validFilePath);
        assertFalse(isValidFilePath);
    }
}

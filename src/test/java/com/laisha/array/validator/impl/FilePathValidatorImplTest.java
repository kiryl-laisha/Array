package com.laisha.array.validator.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathValidatorImplTest {

    private static FilePathValidatorImpl filePathValidator = FilePathValidatorImpl.getInstance();

    @Test
    public void validateExistFilePath() {

        String validFilePath = "data/validator_data/valid_file.txt";
        boolean isValidFilePath = filePathValidator.validateFilePath(validFilePath);
        assertTrue(isValidFilePath);
    }

    @Test
    public void validateNotExistFilePath() {

        String invalidFilePath = "data/validator_data/file.txt";
        boolean isValidFilePath = filePathValidator.validateFilePath(invalidFilePath);
        assertFalse(isValidFilePath);
    }

    @Test
    public void validateNullFilePath() {

        boolean isValidFilePath = filePathValidator.validateFilePath(null);
        assertFalse(isValidFilePath);
    }

    @Test
    public void validateExistFilePathWithEmptyFile() {

        String validFilePath = "data/validator_data/empty_file.txt";
        boolean isValidFilePath = filePathValidator.validateFilePath(validFilePath);
        assertFalse(isValidFilePath);
    }
}

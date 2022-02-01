package com.laisha.array.validator.impl;

import com.laisha.array.validator.FilePathValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;

public class FilePathValidatorImpl implements FilePathValidator {

    private static final Logger logger = LogManager.getLogger();
    private static final FilePathValidatorImpl instance = new FilePathValidatorImpl();
    public static final String WINDOWS_DIRECTORY_SEPARATOR = "\\";
    public static final String UNIX_DIRECTORY_SEPARATOR = "/";

    private FilePathValidatorImpl() {
    }

    public static FilePathValidatorImpl getInstance() {

        return instance;
    }

    public boolean validateFilePath(String filepath) {

        boolean isValidFilePath = false;

        if (filepath != null) {
            filepath = filepath.replace(WINDOWS_DIRECTORY_SEPARATOR, UNIX_DIRECTORY_SEPARATOR);
            URL dataFileUrl = getClass().getClassLoader().getResource(filepath);
            if (dataFileUrl != null) {
                File dataFile = new File(dataFileUrl.getFile());
                if (dataFile.length() > 0) {
                    logger.log(Level.DEBUG, "The file path \"{}\" is correct and " +
                            "the file is not empty.", dataFile);
                    isValidFilePath = true;
                } else {
                    logger.log(Level.INFO, "The file for the file path \"{}\" " +
                            "is empty", dataFile);
                }
            } else {
                logger.log(Level.DEBUG, "The file for the file path \"{}\"" +
                        " is not exist.", filepath);
            }
        } else {
            logger.log(Level.INFO, "The provided file path is null.");
        }
        return isValidFilePath;
    }
}


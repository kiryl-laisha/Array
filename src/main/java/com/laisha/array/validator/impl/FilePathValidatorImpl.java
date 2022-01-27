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

    private FilePathValidatorImpl() {

    }

    public static FilePathValidatorImpl getInstance() {

        return instance;
    }

    public boolean validateFilePath(String filepath) {

        boolean isValidFilePath = false;

        if (filepath == null) {
            logger.log(Level.INFO, "The provided file path is null.");
        } else {
            filepath = filepath.replace("\\", "/");
            URL dataFileUrl = getClass().getClassLoader().getResource(filepath);
            File dataFile;
            try {
                dataFile = new File(dataFileUrl.getFile());
            } catch (NullPointerException nullPointerException) {//TODO should use other exception
                logger.log(Level.DEBUG, "The file for the file path \"{}\"" +
                        " is not exist.", filepath);
                return isValidFilePath;
            }
            if (dataFile.length() > 0) {
                logger.log(Level.DEBUG, "The file path \"{}\" is correct and " +
                        "the file is not empty.", dataFile);
                isValidFilePath = true;
            } else {
                logger.log(Level.INFO, "The file for the file path \"{}\" " +
                        "has size 0.", dataFile);
            }
        }
        return isValidFilePath;
    }
}


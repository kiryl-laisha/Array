package com.laisha.array.reader.impl;

import com.laisha.array.exception.ProjectException;
import com.laisha.array.reader.ReaderFromFile;
import com.laisha.array.validator.impl.FilePathValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderFromFileImpl implements ReaderFromFile {

    private static final Logger logger = LogManager.getLogger();
    private static final ReaderFromFileImpl instance = new ReaderFromFileImpl();
    private String defaultFilePath ="data/default_data_arrays.txt.";

    private ReaderFromFileImpl() {

    }

    public static ReaderFromFileImpl getInstance() {

        return instance;
    }

    @Override
    public List<String> readListStringFromFile(String filepath, boolean defaultFileUsing)
            throws ProjectException {

        logger.log(Level.DEBUG, "The file path is \"{}\" , a default file using is \"{}\",",
                filepath, defaultFileUsing);
        FilePathValidatorImpl filePathValidator = FilePathValidatorImpl.getInstance();
        boolean isFilePathValid = filePathValidator.validateFilePath(filepath);

        if (!isFilePathValid) {
            logger.log(Level.INFO, "The default file \"{}\" is used., ", defaultFilePath);
            boolean isDefaultFilePathValid = filePathValidator.validateFilePath(defaultFilePath);
            if (defaultFileUsing && isDefaultFilePathValid) {
                filepath = defaultFilePath;
            } else {
                logger.log(Level.FATAL, "Reading from the files " +
                        "(both provided and default) is not possible.\n" +
                        "Database cannot be loaded from files.");
                throw new RuntimeException("Database cannot be loaded from files.");
            }
        }
        Path filePath = defineFilePath(filepath);
        List<String> stringListFromFile;
        try (Stream<String> stringStream = Files.newBufferedReader(filePath).lines()) {
            stringListFromFile = stringStream.collect(Collectors.toList());
        } catch (IOException ioException) {
            throw new ProjectException("Reading from the file for the file path "
                    + filepath + " is not available, ", ioException);
        }
        logger.log(Level.DEBUG, "The file for the file path \"{}\" has read successfully.\n" +
                "\"{}\" string(s) have been read.", filepath, stringListFromFile.size());
        return stringListFromFile;
    }

    private Path defineFilePath(String filepath) {

        filepath = filepath.replace("\\", "/");
        URL dataFileUrl = getClass().getClassLoader().getResource(filepath);
        File dataFile = new File(dataFileUrl.getFile());
        return (Paths.get(dataFile.getAbsolutePath()));
    }

    public void setDefaultFilePath(String defaultFilePath) {

        this.defaultFilePath = defaultFilePath;
    }

    public String getDefaultFilePath() {

        return defaultFilePath;
    }
}
package com.laisha.array.reader.impl;

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

public class DataBaseReaderFromFileImpl implements ReaderFromFile {

    private static final Logger logger = LogManager.getLogger();
    private static final DataBaseReaderFromFileImpl instance = new DataBaseReaderFromFileImpl();
    private static final String WINDOWS_DIRECTORY_SEPARATOR = "\\";
    private static final String UNIX_DIRECTORY_SEPARATOR = "/";

    public static String defaultFilePath = "data/default_data_arrays.txt.";

    private DataBaseReaderFromFileImpl() {
    }

    public static DataBaseReaderFromFileImpl getInstance() {

        return instance;
    }

    @Override
    public List<String> readStringListFromFile(String filepath, boolean defaultFilePathUsing) {

        logger.log(Level.DEBUG, "The file path is \"{}\", a default file using is \"{}\".",
                filepath, defaultFilePathUsing);
        Path path = defineFilePathForData(filepath, defaultFilePathUsing);
        List<String> stringListFromFile;
        try (Stream<String> stringStream = Files.newBufferedReader(path).lines()) {
            stringListFromFile = stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.FATAL, "Reading from the file is not available. " +
                    "Database can't be loaded.");
            throw new RuntimeException("Database cannot be loaded from file.", e);
        }
        logger.log(Level.DEBUG, "The file for the file path \"{}\" has read successfully.\n" +
                "{} string(s) have been read.", filepath, stringListFromFile.size());
        return stringListFromFile;
    }

    private Path defineFilePathForData(String filepath, boolean defaultFilePathUsing) {

        FilePathValidatorImpl filePathValidator = FilePathValidatorImpl.getInstance();
        boolean isFilePathValid = filePathValidator.validateFilePath(filepath);
        if (!isFilePathValid && !defaultFilePathUsing) {
            logger.log(Level.FATAL, "Reading from the file is not possible. " +
                    "Default file path doesn't use.\nDatabase can't be loaded.");
            throw new RuntimeException("Database cannot be loaded from file.");
        }
        if (!isFilePathValid) {
            logger.log(Level.WARN, "The default file path \"{}\" is used.", defaultFilePath);
            boolean isDefaultFilePathValid = filePathValidator.validateFilePath(defaultFilePath);
            if (isDefaultFilePathValid) {
                filepath = defaultFilePath;
            } else {
                logger.log(Level.FATAL, "Reading from the files " +
                        "(both provided and default) is not possible.\n" +
                        "Database cannot be loaded.");
                throw new RuntimeException("Database cannot be loaded from files.");
            }
        }
        filepath = filepath.replace(WINDOWS_DIRECTORY_SEPARATOR, UNIX_DIRECTORY_SEPARATOR);
        URL dataFileUrl = getClass().getClassLoader().getResource(filepath);
        if (dataFileUrl == null) {
            logger.log(Level.FATAL, "URL for the file path \"{}\" could not be found. " +
                    "Reading from the file is not possible.\n" +
                    "Database cannot be loaded.", filepath);
            throw new RuntimeException("URL for the file path \"" + filepath + "\" could not " +
                    "be found. Database cannot be loaded from file.");
        }
        File dataFile = new File(dataFileUrl.getFile());
        if (dataFile.length() == 0) {
            logger.log(Level.FATAL, "Reading from the file \"{}\" is not possible, " +
                    "file is empty.\nDatabase cannot be loaded.", filepath);
            throw new RuntimeException("File \"" + filepath + "\" " +
                    "is empty. Database cannot be loaded.");
        }
        return (Paths.get(dataFile.getAbsolutePath()));
    }
}

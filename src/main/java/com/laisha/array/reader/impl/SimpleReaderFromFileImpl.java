package com.laisha.array.reader.impl;

import com.laisha.array.exception.ProjectException;
import com.laisha.array.validator.impl.FilePathValidatorImpl;
import com.laisha.array.reader.ReaderFromFile;
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

public class SimpleReaderFromFileImpl implements ReaderFromFile {

    private static final Logger logger = LogManager.getLogger();
    private static final SimpleReaderFromFileImpl instance = new SimpleReaderFromFileImpl();
    private static final String WINDOWS_DIRECTORY_SEPARATOR = "\\";
    private static final String UNIX_DIRECTORY_SEPARATOR = "/";

    private String defaultFilePath = "data/default_data_strings.txt.";

    private SimpleReaderFromFileImpl() {

    }

    public static SimpleReaderFromFileImpl getInstance() {

        return instance;
    }

    @Override
    public List<String> readListStringFromFile(String filepath, boolean defaultFileUsing)
            throws ProjectException {

        logger.log(Level.DEBUG, "The file path is \"{}\", a default file using is \"{}\".",
                filepath, defaultFileUsing);
        FilePathValidatorImpl filePathValidator = FilePathValidatorImpl.getInstance();
        boolean isFilePathValid = filePathValidator.validateFilePath(filepath);

        if (!isFilePathValid) {
            if (defaultFileUsing) {
                logger.log(Level.INFO, "The default file \"{}\" is used.", defaultFilePath);
                if (filePathValidator.validateFilePath(defaultFilePath)) {
                    filepath = defaultFilePath;
                } else {
                    throw new ProjectException("Reading from the files (both provided and default) " +
                            "is not possible.");
                }
            } else {
                throw new ProjectException("Reading from the file for the file path "
                        + filepath + " is not available.");
            }
        }
        Path filePath = defineFilePath(filepath);
        List<String> stringListFromFile;
        try (Stream<String> stringStream = Files.newBufferedReader(filePath).lines()) {
            stringListFromFile = stringStream.collect(Collectors.toList());
        } catch (IOException ioException) {
            throw new ProjectException("Reading from the file for the file path \""
                    + filepath + "\" is not available, ", ioException);
        }
        logger.log(Level.DEBUG, "The file for the file path \"{}\" has read successfully.\n" +
                "{} string(s) have been read.", filepath, stringListFromFile.size());
        return stringListFromFile;
    }

    private Path defineFilePath(String filepath) {

        filepath = filepath.replace(WINDOWS_DIRECTORY_SEPARATOR, UNIX_DIRECTORY_SEPARATOR);
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

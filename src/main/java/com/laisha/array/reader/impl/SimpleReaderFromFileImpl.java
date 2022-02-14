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

public class SimpleReaderFromFileImpl implements ReaderFromFile {

    private static final Logger logger = LogManager.getLogger();
    private static final SimpleReaderFromFileImpl instance = new SimpleReaderFromFileImpl();
    private static final String WINDOWS_DIRECTORY_SEPARATOR = "\\";
    private static final String UNIX_DIRECTORY_SEPARATOR = "/";

    public static String defaultFilePath = "data/default_data_strings.txt";

    private SimpleReaderFromFileImpl() {
    }

    public static SimpleReaderFromFileImpl getInstance() {
        return instance;
    }

    @Override
    public List<String> readStringListFromFile(String filepath, boolean defaultFilePathUsing)
            throws ProjectException {

        logger.log(Level.DEBUG, "The file path is \"{}\", a default file using is \"{}\".",
                filepath, defaultFilePathUsing);
        Path path = defineFilePathForData(filepath, defaultFilePathUsing);
        List<String> stringListFromFile;
        try (Stream<String> stringStream = Files.newBufferedReader(path).lines()) {
            stringListFromFile = stringStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new ProjectException("Reading from the file for the file path \""
                    + filepath + "\" is not available, ", e);
        }
        logger.log(Level.DEBUG, "The file for the file path \"{}\" has read successfully.\n" +
                "{} string(s) have been read.", filepath, stringListFromFile.size());
        return stringListFromFile;
    }

    private Path defineFilePathForData(String filepath, boolean defaultFilePathUsing)
            throws ProjectException{

        FilePathValidatorImpl validator = FilePathValidatorImpl.getInstance();
        boolean isFilePathValid = validator.validateFilePath(filepath);
        if (!isFilePathValid && !defaultFilePathUsing) {
            throw new ProjectException("Reading from the file is not possible. " +
                    "Default file path doesn't use.");
        }
        if (!isFilePathValid) {
            logger.log(Level.WARN, "The default file path \"{}\" is used.", defaultFilePath);
            boolean isDefaultFilePathValid = validator.validateFilePath(defaultFilePath);
            if (isDefaultFilePathValid) {
                filepath = defaultFilePath;
            } else {
                throw new ProjectException("Reading from the files (both " +
                        "provided and default) is not possible.");
            }
        }
        filepath = filepath.replace(WINDOWS_DIRECTORY_SEPARATOR, UNIX_DIRECTORY_SEPARATOR);
        URL dataFileUrl = getClass().getClassLoader().getResource(filepath);
        if (dataFileUrl == null) {
            throw new ProjectException("URL for the file path \"" + filepath + "\" could not " +
                    "be found. Reading from the file is not possible.");
        }
        File dataFile = new File(dataFileUrl.getFile());
        if (dataFile.length() == 0) {
            logger.log(Level.FATAL, "Reading from the file \"{}\" is not possible, " +
                    "file is empty.\nDatabase cannot be loaded.", filepath);
            throw new ProjectException("File \"" + filepath + "\" " +
                    "is empty. Reading from the file is not possible.");
        }
        return (Paths.get(dataFile.getAbsolutePath()));
    }
}

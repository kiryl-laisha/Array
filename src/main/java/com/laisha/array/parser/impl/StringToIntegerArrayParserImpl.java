package com.laisha.array.parser.impl;

import com.laisha.array.exception.ProjectException;
import com.laisha.array.parser.StringToIntegerArrayParser;
import com.laisha.array.validator.impl.StringAsIntegerArrayValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringToIntegerArrayParserImpl implements StringToIntegerArrayParser {

    private static final Logger logger = LogManager.getLogger();
    private static final StringToIntegerArrayParserImpl instance =
            new StringToIntegerArrayParserImpl();
    private static final String ELEMENTS_DELIMITER = "\\s+";

    private StringToIntegerArrayParserImpl() {
    }

    public static StringToIntegerArrayParserImpl getInstance() {
        return instance;
    }

    @Override
    public int[] parseStringToIntegerArray(String stringAsArray) throws ProjectException {

        if (stringAsArray == null) {
            throw new ProjectException("The provided string is null.");
        }
        if (stringAsArray.isBlank()) {
            return new int[]{};
        }
        StringAsIntegerArrayValidatorImpl validator =
                StringAsIntegerArrayValidatorImpl.getInstance();
        if (!validator.validateStringAsArray(stringAsArray)) {
            throw new ProjectException("The provided string \"" + stringAsArray +
                    "\" is not valid as integer array.");
        }
        stringAsArray = stringAsArray.strip();
        String[] arrayElementStrings = stringAsArray.split(ELEMENTS_DELIMITER);
        int[] integerArray = Arrays.stream(arrayElementStrings)
                .flatMapToInt(x -> IntStream.of(Integer.parseInt(x)))
                .toArray();
        logger.log(Level.DEBUG, "The string \"{}\" has been parsed by " +
                "integer array.", stringAsArray);
        return integerArray;
    }
}

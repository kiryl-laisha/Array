package com.laisha.array.validator.impl;

import com.laisha.array.validator.StringAsArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringAsIntegerArrayValidatorImpl implements StringAsArrayValidator {

    private static final Logger logger = LogManager.getLogger();
    private static final StringAsIntegerArrayValidatorImpl instance =
            new StringAsIntegerArrayValidatorImpl();
    private static final String STRING_AS_INTEGER = "(([-+]?[0]*((\\d{1,9})|([1]\\d{9})))|" +
            "([+]?[0]*([2](([0]\\d{8})|([1](([0-3]\\d{7})|([4](([0-6]\\d{6})|" +
            "([7](([03]\\d{5})|([4](([0-7]\\d{4})|([8](([0-2]\\d{3})|" +
            "([3](([0-5]\\d{2})|([6](([0-3]\\d)|([4][0-7]))))))))))))))))))|" +
            "([-][0]*([2](([0]\\d{8})|([1](([0-3]\\d{7})|([4](([0-6]\\d{6})|" +
            "([7](([03]\\d{5})|([4](([0-7]\\d{4})|([8](([0-2]\\d{3})|" +
            "([3](([0-5]\\d{2})|([6](([0-3]\\d)|([4][0-8])))))))))))))))))))";
    private static final String STRING_AS_INTEGER_ARRAY = "^\\s*" + STRING_AS_INTEGER +
            "(\\s+" + STRING_AS_INTEGER + ")*\\s*$";

    private StringAsIntegerArrayValidatorImpl() {

    }

    public static StringAsIntegerArrayValidatorImpl getInstance() {

        return instance;
    }

    @Override
    public boolean validateStringAsArray(String stringArray) {

        boolean isValidStringAsIntegerArray = false;
        if (stringArray != null) {
            if (stringArray.matches(STRING_AS_INTEGER_ARRAY)) {
                isValidStringAsIntegerArray = true;
            } else {
                logger.log(Level.DEBUG, "The string \"{}\" is not valid as " +
                        "integer array.", stringArray);
            }
        }
        return isValidStringAsIntegerArray;
    }
}

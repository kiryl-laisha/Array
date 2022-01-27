package com.laisha.array.validator.impl;

import com.laisha.array.validator.StringValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidatorImpl implements StringValidator {

    public static final String STRING_AS_INTEGER_ARRAY = "(\\s+-?\\d+\\s+)+";
    private static final StringValidatorImpl instance = new StringValidatorImpl();

    private StringValidatorImpl() {
    }

    public StringValidatorImpl getInstance() {
        return instance;
    }

    @Override
    public boolean validateStringAsIntegerArray(String string) {
        Pattern pattern = Pattern.compile(STRING_AS_INTEGER_ARRAY);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}

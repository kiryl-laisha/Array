package com.laisha.array.parser.impl;

import com.laisha.array.parser.StringToIntegerArrayParser;

public class StringToIntegerArrayParserImpl implements StringToIntegerArrayParser {

    public static final String STRING_AS_INTEGER = "\\s*-?\\d+\\s*";

    @Override
    public int[] parseStringToIntegerArray(String string) {
        String[] stringsArray = string.split(STRING_AS_INTEGER);
        int[] integerArray = new int[stringsArray.length];
        for (int i = 0; i < stringsArray.length; i++) {
            integerArray[i] = Integer.parseInt(stringsArray[i]);
        }
        return integerArray;
    }
}

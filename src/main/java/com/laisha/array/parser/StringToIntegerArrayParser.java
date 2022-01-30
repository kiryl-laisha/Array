package com.laisha.array.parser;

import com.laisha.array.exception.ProjectException;

public interface StringToIntegerArrayParser {

    int[] parseStringToIntegerArray(String string) throws ProjectException;
}

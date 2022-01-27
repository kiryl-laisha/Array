package com.laisha.array.main;

import com.laisha.array.exception.ProjectException;
import com.laisha.array.reader.impl.ReaderFromFileImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        log.log(Level.INFO, "first log");
        List<String> stringList = new ArrayList<>();
        ReaderFromFileImpl readerFromFile =ReaderFromFileImpl.getInstance();
        try {
            stringList = readerFromFile.readListStringFromFile(
                    "data/data_arrays.txt", false);
        } catch (ProjectException projectException) {
            log.log(Level.ERROR, "file not found");
        }
        System.out.println(stringList.toString());

//        StringToIntegerArrayParserImpl stringToIntegerArrayParser = new StringToIntegerArrayParserImpl();
//        int[] array = stringToIntegerArrayParser.parseStringToIntegerArray(string);
//        CustomIntegerArray intArray = new CustomIntegerArray();
//        intArray.setIntegerArray(array);
//        ArrayActionImpl arrayActionImpl = new ArrayActionImpl();
//        int minElement = arrayActionImpl.findMinElement(intArray);
//        System.out.println(minElement);


    }
}



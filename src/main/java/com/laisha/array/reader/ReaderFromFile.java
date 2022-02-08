package com.laisha.array.reader;

import com.laisha.array.exception.ProjectException;

import java.util.List;

public interface ReaderFromFile {

    List<String> readStringListFromFile(String filePath, boolean defaultFileUsing)
            throws ProjectException;
}

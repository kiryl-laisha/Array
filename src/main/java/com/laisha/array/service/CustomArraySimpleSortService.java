package com.laisha.array.service;

import com.laisha.array.entity.CustomArray;
import com.laisha.array.exception.ProjectException;

public interface CustomArraySimpleSortService {

    void sortByBubbleSorting(CustomArray customArray) throws ProjectException;

    void sortBySelection(CustomArray customArray) throws ProjectException;

    void sortByInsertion(CustomArray customArray) throws ProjectException;

    void sortByStream(CustomArray customArray) throws ProjectException;
}

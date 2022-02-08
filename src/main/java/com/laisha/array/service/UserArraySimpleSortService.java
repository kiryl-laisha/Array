package com.laisha.array.service;

import com.laisha.array.entity.UserArray;
import com.laisha.array.exception.ProjectException;

public interface UserArraySimpleSortService {

    void sortByBubbleSorting(UserArray userArray) throws ProjectException;

    void sortBySelection(UserArray userArray) throws ProjectException;

    void sortByInsertion(UserArray userArray) throws ProjectException;

    void sortByStream(UserArray userArray) throws ProjectException;
}

package com.laisha.array.repository;

import com.laisha.array.entity.UserIntegerArray;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntegerArrayRepository {

    private static final IntegerArrayRepository instance =
            new IntegerArrayRepository();
    private static Set<UserIntegerArray> integerArrays = new HashSet<>();

    private IntegerArrayRepository() {
    }

    public IntegerArrayRepository getInstance() {

        return instance;
    }

    public void addIntegerArray(UserIntegerArray userIntegerArray) {
        integerArrays.add(userIntegerArray);
    }

    public void removeIntegerArray(UserIntegerArray userIntegerArray) {
        integerArrays.remove(userIntegerArray);
    }

    public Set<UserIntegerArray> query(IntegerArraySpecification specification) {

        HashSet<UserIntegerArray> selectedIntegerArrays = new HashSet<>();
        for (UserIntegerArray integerArray : integerArrays) {
            if (specification.specify(integerArray)) {
                selectedIntegerArrays.add(integerArray);
            }
        }
        return selectedIntegerArrays;
    }

    public Set<UserIntegerArray> queryStream(IntegerArraySpecification specification) {

        Set<UserIntegerArray> selectedIntegerArrays;
        selectedIntegerArrays = integerArrays.stream()
                .filter(specification::specify)
                .collect(Collectors.toSet());
        return selectedIntegerArrays;
    }
}

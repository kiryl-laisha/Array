package com.laisha.array.repository;

import com.laisha.array.entity.CustomArray;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomArrayRepository {

    private static final CustomArrayRepository instance = new CustomArrayRepository();
    private static final List<CustomArray> customArrays = new ArrayList<>();

    private CustomArrayRepository() {
    }

    public static CustomArrayRepository getInstance() {
        return instance;
    }

    public void add(CustomArray customArray) {

        if (!customArrays.contains(customArray)) {
            customArrays.add(customArray);
        }
    }

    public void remove(CustomArray customArray) {
        customArrays.remove(customArray);
    }

    public boolean addAll(List<CustomArray> providedCustomArrays) {

        List<CustomArray> addedCustomArrays;
        addedCustomArrays = providedCustomArrays.stream()
                .filter(x -> !customArrays.contains(x))
                .collect(Collectors.toList());
        customArrays.addAll(addedCustomArrays);
        return providedCustomArrays.size() == addedCustomArrays.size();
    }

    public boolean removeAll(List<CustomArray> providedCustomArrays) {

        List<CustomArray> removedCustomArrays;
        removedCustomArrays = providedCustomArrays.stream()
                .filter(customArrays::contains)
                .collect(Collectors.toList());
        customArrays.removeAll(removedCustomArrays);
        return providedCustomArrays.size() == removedCustomArrays.size();
    }

    public Optional<CustomArray> get(int index) {

        if (index < 0 || index >= customArrays.size()) {
            return Optional.empty();
        }
        return Optional.of(customArrays.get(index));
    }

    public int size() {
        return customArrays.size();
    }

    public List<CustomArray> query(CustomArraySpecification specification) {

        List<CustomArray> selectedIntegerArrays = new ArrayList<>();
        for (CustomArray customArray : customArrays) {
            if (specification.specify(customArray)) {
                selectedIntegerArrays.add(customArray);
            }
        }
        return selectedIntegerArrays;
    }

    public List<CustomArray> queryStream(CustomArraySpecification specification) {

        List<CustomArray> selectedIntegerArrays;
        selectedIntegerArrays = customArrays.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        return selectedIntegerArrays;
    }

    public List<CustomArray> queryStreamPredicate(Predicate<CustomArray> predicate) {

        List<CustomArray> selectedIntegerArrays;
        selectedIntegerArrays = customArrays.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        return selectedIntegerArrays;
    }

    public List<CustomArray> sort(Comparator<CustomArray> comparator) {

        List<CustomArray> sortedCustomArrays;
        sortedCustomArrays = customArrays.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(sortedCustomArrays);
    }
}

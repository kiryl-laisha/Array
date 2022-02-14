package com.laisha.array.repository;

import com.laisha.array.comparator.IntegerMinElementComparator;
import com.laisha.array.entity.CustomArray;
import com.laisha.array.factory.impl.CustomArrayFactoryImpl;
import com.laisha.array.repository.impl.MaxElementMoreSpecificationImpl;
import com.laisha.array.repository.impl.MinElementMoreSpecificationImpl;
import com.laisha.array.repository.impl.TotalSumMorePredicate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayRepositoryTest {

    static CustomArrayFactoryImpl arrayFactory = CustomArrayFactoryImpl.getInstance();
    static CustomArrayRepository repository = CustomArrayRepository.getInstance();
    static CustomArray customArray;
    List<CustomArray> customArrays = new ArrayList<>();

    @AfterEach
    void tearDown() {

        customArray = null;
        customArrays = new ArrayList<>();
    }

    @AfterAll
    static void tearDownClass() {

        arrayFactory = null;
        repository = null;
    }

    @Test
    @DisplayName("New object is added successfully.")
    void addFirstPositiveTest() {

        int[] integerArray = {1, 4, 6};
        customArray = arrayFactory.createCustomArray(integerArray);
        repository.add(customArray);
        int expect = 1;//One object is added
        int actual = repository.size();
        repository.remove(customArray);
        assertEquals(expect, actual);
    }

    @Test
    @DisplayName("Duplicate object is not added.")
    void addSecondPositiveTest() {

        int[] integerArray = {1, 4, 6};
        customArray = arrayFactory.createCustomArray(integerArray);
        repository.add(customArray);
        repository.add(customArray);
        int expected = 1;//One object is added
        int actual = repository.size();
        repository.remove(customArray);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Exist object is removed successfully.")
    void removePositiveTest() {

        int[] integerArray = {1, 4, 6};
        customArray = arrayFactory.createCustomArray(integerArray);
        repository.add(customArray);
        repository.remove(customArray);
        int expected = 0;//One object is added and removed then
        int actual = repository.size();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Three new objects are added successfully.")
    void addAllPositiveTest() {

        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 2}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 5}));
        boolean actual = repository.addAll(customArrays);
        repository.removeAll(customArrays);
        assertTrue(actual);
    }

    @Test
    @DisplayName("Duplicate objects are not added to repository.")
    void addAllNegativeTest() {

        customArray = arrayFactory.createCustomArray(new int[]{1, 2});
        customArrays.add(customArray);
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 5}));
        repository.add(customArray);
        boolean actual = repository.addAll(customArrays);
        repository.removeAll(customArrays);
        assertFalse(actual);
    }

    @Test
    @DisplayName("Three contained objects are removed successfully.")
    void removeAllPositiveTest() {

        List<CustomArray> removedCustomArrays;
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 2}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 5}));
        repository.addAll(customArrays);
        removedCustomArrays = customArrays;
        boolean actual = repository.removeAll(removedCustomArrays);
        assertTrue(actual);
    }

    @Test
    @DisplayName("Not contained objects are not removed.")
    void removeAllNegativeTest() {

        List<CustomArray> removedCustomArrays;
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 5}));
        repository.addAll(customArrays);
        removedCustomArrays = customArrays;
        customArray = arrayFactory.createCustomArray(new int[]{1, 2});
        removedCustomArrays.add(customArray);
        boolean actual = repository.removeAll(removedCustomArrays);
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    @DisplayName("Contained object are get for valid index.")
    void getPositiveTest(int index) {

        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 2}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 5}));
        repository.addAll(customArrays);
        Optional<CustomArray> optionalUserArray = repository.get(index);
        boolean actual = optionalUserArray.isPresent();
        repository.removeAll(customArrays);
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("Contained object are not get for invalid index.")
    void getNegativeTest(int index) {

        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 2}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 5}));
        repository.addAll(customArrays);
        Optional<CustomArray> optionalUserArray = repository.get(index);
        boolean actual = optionalUserArray.isPresent();
        repository.removeAll(customArrays);
        assertFalse(actual);
    }

    @Test
    @DisplayName("Uses a specification for maximum element more than provided value.")
    void queryPositiveTest() {

        CustomArraySpecification specification = new MaxElementMoreSpecificationImpl(4);
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 2}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 5}));
        repository.addAll(customArrays);
        List<CustomArray> specifiedCustomArrays = repository.query(specification);
        int expected = 1;
        int actual = specifiedCustomArrays.size();
        repository.removeAll(customArrays);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Uses a specification for minimum element more than provided value.")
    void queryStreamPositiveTest() {

        CustomArraySpecification specification = new MinElementMoreSpecificationImpl(0);
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 2}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{-1, 5}));
        repository.addAll(customArrays);
        List<CustomArray> specifiedCustomArrays = repository.queryStream(specification);
        int expected = 2;
        int actual = specifiedCustomArrays.size();
        repository.removeAll(customArrays);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(longs = {3, 4})
    @DisplayName("Uses a predicate for total sum more than provided value.")
    void queryStreamPredicatePositiveTest(long totalSum) {

        Predicate<CustomArray> predicate = new TotalSumMorePredicate(totalSum);
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 1}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{-1, 7}));
        repository.addAll(customArrays);
        List<CustomArray> specifiedCustomArrays = repository.queryStreamPredicate(predicate);
        int expected = 2;
        int actual = specifiedCustomArrays.size();
        repository.removeAll(customArrays);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sorts for minimum element.")
    void sortPositiveTest() {

        CustomArray expectedCustomArray = arrayFactory.createCustomArray(new int[]{-1, 10});
        customArrays.add(expectedCustomArray);
        customArrays.add(arrayFactory.createCustomArray(new int[]{1, 1}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{2, 3}));
        customArrays.add(arrayFactory.createCustomArray(new int[]{5, 15}));
        repository.addAll(customArrays);
        List<CustomArray> sortedCustomArrays = repository.sort(new IntegerMinElementComparator());
        CustomArray actualCustomArray = sortedCustomArrays.get(0);
        repository.removeAll(customArrays);
        assertEquals(expectedCustomArray, actualCustomArray);
    }
}
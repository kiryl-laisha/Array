package com.laisha.array.repository;

import com.laisha.array.comparator.IntegerMinElementComparator;
import com.laisha.array.entity.UserArray;
import com.laisha.array.factory.impl.UserArrayFactoryImpl;
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

class UserArrayRepositoryTest {

    static UserArrayFactoryImpl arrayFactory = UserArrayFactoryImpl.getInstance();
    static UserArrayRepository repository = UserArrayRepository.getInstance();
    static UserArray userArray;
    List<UserArray> userArrays = new ArrayList<>();

    @AfterEach
    void tearDown() {

        userArray = null;
        userArrays = new ArrayList<>();
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
        userArray = arrayFactory.createUserArray(integerArray);
        repository.add(userArray);
        int expect = 1;//One object is added
        int actual = repository.size();
        repository.remove(userArray);
        assertEquals(expect, actual);
    }

    @Test
    @DisplayName("Duplicate object is not added.")
    void addSecondPositiveTest() {

        int[] integerArray = {1, 4, 6};
        userArray = arrayFactory.createUserArray(integerArray);
        repository.add(userArray);
        repository.add(userArray);
        int expected = 1;//One object is added
        int actual = repository.size();
        repository.remove(userArray);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Exist object is removed successfully.")
    void removePositiveTest() {

        int[] integerArray = {1, 4, 6};
        userArray = arrayFactory.createUserArray(integerArray);
        repository.add(userArray);
        repository.remove(userArray);
        int expected = 0;//One object is added and removed then
        int actual = repository.size();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Three new objects are added successfully.")
    void addAllPositiveTest() {

        userArrays.add(arrayFactory.createUserArray(new int[]{1, 2}));
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 5}));
        boolean actual = repository.addAll(userArrays);
        repository.removeAll(userArrays);
        assertTrue(actual);
    }

    @Test
    @DisplayName("Duplicate objects are not added to repository.")
    void addAllNegativeTest() {

        userArray = arrayFactory.createUserArray(new int[]{1, 2});
        userArrays.add(userArray);
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 5}));
        repository.add(userArray);
        boolean actual = repository.addAll(userArrays);
        repository.removeAll(userArrays);
        assertFalse(actual);
    }

    @Test
    @DisplayName("Three contained objects are removed successfully.")
    void removeAllPositiveTest() {

        List<UserArray> removedUserArrays;
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 2}));
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 5}));
        repository.addAll(userArrays);
        removedUserArrays = userArrays;
        boolean actual = repository.removeAll(removedUserArrays);
        assertTrue(actual);
    }

    @Test
    @DisplayName("Not contained objects are not removed.")
    void removeAllNegativeTest() {

        List<UserArray> removedUserArrays;
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 5}));
        repository.addAll(userArrays);
        removedUserArrays = userArrays;
        userArray = arrayFactory.createUserArray(new int[]{1, 2});
        removedUserArrays.add(userArray);
        boolean actual = repository.removeAll(removedUserArrays);
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    @DisplayName("Contained object are get for valid index.")
    void getPositiveTest(int index) {

        userArrays.add(arrayFactory.createUserArray(new int[]{1, 2}));
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 5}));
        repository.addAll(userArrays);
        Optional<UserArray> optionalUserArray = repository.get(index);
        boolean actual = optionalUserArray.isPresent();
        repository.removeAll(userArrays);
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("Contained object are not get for invalid index.")
    void getNegativeTest(int index) {

        userArrays.add(arrayFactory.createUserArray(new int[]{1, 2}));
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 5}));
        repository.addAll(userArrays);
        Optional<UserArray> optionalUserArray = repository.get(index);
        boolean actual = optionalUserArray.isPresent();
        repository.removeAll(userArrays);
        assertFalse(actual);
    }

    @Test
    @DisplayName("Uses a specification for maximum element more than provided value.")
    void queryPositiveTest() {

        UserArraySpecification specification = new MaxElementMoreSpecificationImpl(4);
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 2}));
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 5}));
        repository.addAll(userArrays);
        List<UserArray> specifiedUserArrays = repository.query(specification);
        int expected = 1;
        int actual = specifiedUserArrays.size();
        repository.removeAll(userArrays);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Uses a specification for minimum element more than provided value.")
    void queryStreamPositiveTest() {

        UserArraySpecification specification = new MinElementMoreSpecificationImpl(0);
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 2}));
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{-1, 5}));
        repository.addAll(userArrays);
        List<UserArray> specifiedUserArrays = repository.queryStream(specification);
        int expected = 2;
        int actual = specifiedUserArrays.size();
        repository.removeAll(userArrays);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(longs = {3, 4})
    @DisplayName("Uses a predicate for total sum more than provided value.")
    void queryStreamPredicatePositiveTest(long totalSum) {

        Predicate<UserArray> predicate = new TotalSumMorePredicate(totalSum);
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 1}));
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{-1, 7}));
        repository.addAll(userArrays);
        List<UserArray> specifiedUserArrays = repository.queryStreamPredicate(predicate);
        int expected = 2;
        int actual = specifiedUserArrays.size();
        repository.removeAll(userArrays);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sorts for minimum element.")
    void sortPositiveTest() {

        UserArray expectedUserArray = arrayFactory.createUserArray(new int[]{-1, 10});
        userArrays.add(expectedUserArray);
        userArrays.add(arrayFactory.createUserArray(new int[]{1, 1}));
        userArrays.add(arrayFactory.createUserArray(new int[]{2, 3}));
        userArrays.add(arrayFactory.createUserArray(new int[]{5, 15}));
        repository.addAll(userArrays);
        List<UserArray> sortedUserArrays = repository.sort(new IntegerMinElementComparator());
        UserArray actualUserArray = sortedUserArrays.get(0);
        repository.removeAll(userArrays);
        assertEquals(expectedUserArray, actualUserArray);
    }
}
package com.laisha.array.repository;

import com.laisha.array.entity.UserArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserArrayRepository {

    private static final UserArrayRepository instance =
            new UserArrayRepository();
    private static final List<UserArray> userArrays = new ArrayList<>();

    private UserArrayRepository() {
    }

    public static UserArrayRepository getInstance() {
        return instance;
    }

    public void add(UserArray userArray) {

        if (!userArrays.contains(userArray)) {
            userArrays.add(userArray);
        }
    }

    public void remove(UserArray userArray) {
        userArrays.remove(userArray);
    }

    public boolean addAll(List<UserArray> providedUserArrays) {

        List<UserArray> addedUserArrays;
        addedUserArrays = providedUserArrays.stream()
                .filter(x -> !userArrays.contains(x))
                .collect(Collectors.toList());
        userArrays.addAll(addedUserArrays);
        return providedUserArrays.size() == addedUserArrays.size();
    }

    public boolean removeAll(List<UserArray> providedUserArrays) {

        List<UserArray> removedUserArrays;
        removedUserArrays = providedUserArrays.stream()
                .filter(userArrays::contains)
                .collect(Collectors.toList());
        userArrays.removeAll(removedUserArrays);
        return providedUserArrays.size() == removedUserArrays.size();
    }

    public Optional<UserArray> get(int index) {

        if (index < 0 || index >= userArrays.size()) {
            return Optional.empty();
        }
        return Optional.of(userArrays.get(index));
    }

    public int size() {
        return userArrays.size();
    }

    public List<UserArray> query(UserArraySpecification specification) {

        List<UserArray> selectedIntegerArrays = new ArrayList<>();
        for (UserArray userArray : userArrays) {
            if (specification.specify(userArray)) {
                selectedIntegerArrays.add(userArray);
            }
        }
        return selectedIntegerArrays;
    }

    public List<UserArray> queryStream(UserArraySpecification specification) {

        List<UserArray> selectedIntegerArrays;
        selectedIntegerArrays = userArrays.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        return selectedIntegerArrays;
    }

    public List<UserArray> queryStreamPredicate(Predicate<UserArray> predicate) {

        List<UserArray> selectedIntegerArrays;
        selectedIntegerArrays = userArrays.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        return selectedIntegerArrays;
    }

    public List<UserArray> sort(Comparator<UserArray> comparator) {

        List<UserArray> sortedUserArrays;
        sortedUserArrays = userArrays.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sortedUserArrays;
    }
}

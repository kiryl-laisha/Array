package com.laisha.array.creator.impl;

import com.laisha.array.creator.UserArrayCreator;
import com.laisha.array.entity.UserArray;
import com.laisha.array.factory.impl.UserArrayFactoryImpl;
import com.laisha.array.filler.impl.UserArrayRepositoryFiller;
import com.laisha.array.filler.impl.UserArrayWarehouseFiller;
import com.laisha.array.observer.UserArrayObserver;
import com.laisha.array.observer.impl.UserIntegerArrayObserverImpl;

public class UserArrayCreatorImpl implements UserArrayCreator {

    private static final UserArrayCreatorImpl instance = new UserArrayCreatorImpl();
    private static final UserArrayFactoryImpl arrayFactory = UserArrayFactoryImpl.getInstance();
    private static final UserArrayRepositoryFiller repositoryFiller =
            UserArrayRepositoryFiller.getInstance();
    private static final UserArrayWarehouseFiller warehouseFiller =
            UserArrayWarehouseFiller.getInstance();

    private UserArrayCreatorImpl() {
    }

    public static UserArrayCreatorImpl getInstance() {
        return instance;
    }

    @Override
    public UserArray createUserArray() {

        UserArray userArray = arrayFactory.createUserArray();
        repositoryFiller.fill(userArray);
        UserArrayObserver arrayObserver = new UserIntegerArrayObserverImpl();
        userArray.attach(arrayObserver);
        return userArray;
    }

    @Override
    public UserArray createUserArray(int... integerArray) {

        if (integerArray == null) {
             return createUserArray();
        }
        UserArray userArray = arrayFactory.createUserArray(integerArray);
        repositoryFiller.fill(userArray);
        UserArrayObserver arrayObserver = new UserIntegerArrayObserverImpl();
        userArray.attach(arrayObserver);
        if (integerArray.length > 0) {
            warehouseFiller.fill(userArray);
        }
        return userArray;
    }
}

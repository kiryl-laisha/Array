package com.laisha.array.creator.impl;

import com.laisha.array.creator.CustomArrayCreator;
import com.laisha.array.entity.CustomArray;
import com.laisha.array.factory.impl.CustomArrayFactoryImpl;
import com.laisha.array.filler.impl.CustomArrayRepositoryFiller;
import com.laisha.array.filler.impl.CustomArrayWarehouseFiller;
import com.laisha.array.observer.CustomArrayObserver;
import com.laisha.array.observer.impl.CustomIntegerArrayObserverImpl;

public class CustomArrayCreatorImpl implements CustomArrayCreator {

    private static final CustomArrayCreatorImpl instance = new CustomArrayCreatorImpl();
    private static final CustomArrayFactoryImpl arrayFactory = CustomArrayFactoryImpl.getInstance();
    private static final CustomArrayRepositoryFiller repositoryFiller =
            CustomArrayRepositoryFiller.getInstance();
    private static final CustomArrayWarehouseFiller warehouseFiller =
            CustomArrayWarehouseFiller.getInstance();

    private CustomArrayCreatorImpl() {
    }

    public static CustomArrayCreatorImpl getInstance() {
        return instance;
    }

    @Override
    public CustomArray createCustomArray() {

        CustomArray customArray = arrayFactory.createCustomArray();
        repositoryFiller.fill(customArray);
        CustomArrayObserver observer = new CustomIntegerArrayObserverImpl();
        customArray.attach(observer);
        return customArray;
    }

    @Override
    public CustomArray createCustomArray(int... integerArray) {

        if (integerArray == null) {
             return createCustomArray();
        }
        CustomArray customArray = arrayFactory.createCustomArray(integerArray);
        repositoryFiller.fill(customArray);
        CustomArrayObserver observer = new CustomIntegerArrayObserverImpl();
        customArray.attach(observer);
        if (integerArray.length > 0) {
            warehouseFiller.fill(customArray);
        }
        return customArray;
    }
}

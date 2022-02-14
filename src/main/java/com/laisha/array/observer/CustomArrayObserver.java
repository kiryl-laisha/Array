package com.laisha.array.observer;

import com.laisha.array.entity.CustomArrayEvent;

public interface CustomArrayObserver {

    void changeParameters(CustomArrayEvent event);
}

package com.laisha.array.observer;

import com.laisha.array.entity.UserArrayEvent;

public interface UserArrayObserver {

    void changeParameters(UserArrayEvent event);
}

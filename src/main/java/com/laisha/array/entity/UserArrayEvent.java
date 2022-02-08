package com.laisha.array.entity;

import java.util.EventObject;

public class UserArrayEvent extends EventObject {

    public UserArrayEvent(UserArray source) {
        super(source);
    }

    @Override
    public UserArray getSource() {
        return (UserArray) super.getSource();
    }
}

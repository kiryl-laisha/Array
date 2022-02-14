package com.laisha.array.entity;

import java.util.EventObject;

public class CustomArrayEvent extends EventObject {

    public CustomArrayEvent(CustomArray source) {
        super(source);
    }

    @Override
    public CustomArray getSource() {
        return (CustomArray) super.getSource();
    }
}

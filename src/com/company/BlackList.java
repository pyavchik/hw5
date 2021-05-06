package com.company;

import java.util.Objects;

public class BlackList {
    private Class[] classes;

    public BlackList() {
        classes = new Class[10];
    }

    public void add(Class object) {
        for (int i = 0; i < classes.length; i++) {
            if (Objects.isNull(classes[i])) {
                classes[i] = object;
                break;
            }
        }
    }

    public boolean isPresent(Class object){
        for (Class aClass : classes) {
            if(aClass.equals(object)){
                return true;
            }
        }

        return false;
    }
}

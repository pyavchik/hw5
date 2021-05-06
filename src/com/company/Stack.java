package com.company;

import java.util.Objects;

public class Stack<T> implements Actionable<T> {
    public static final int STACK_SIZE = 10;
    private T[] array;
    private BlackList list;
    private int size;

    public Stack(BlackList list) {
        this.array = (T[]) new Object[STACK_SIZE];
        this.list = list;
        this.size = 0;
    }

    @Override
    public void push(T item) {
        if (item != null) {
            final boolean isPresent = list.isPresent(item.getClass());

            if (!isPresent) {

                for (int i = 0; i < array.length; i++) {
                    if (Objects.isNull(array[i])) {
                        array[i] = item;
                        ++size;
                        break;
                    }
                }

            }
            throw new IllegalArgumentException("This class "
                    + item.getClass().getSimpleName()
                    + " is in blacklist");
        } else {
            throw new IllegalArgumentException("Item can't be null");
        }

    }

    @Override
    public T delete() {
        if (size == 0) {
            throw new RuntimeException("Can't delete from empty Stack");
        }
        T item = array[size];

        array[size] = null;
        --size;

        return item;
    }

    @Override
    public T get() {
        if (size == 0) {
            throw new RuntimeException("Can't delete from empty Stack");

        }
        return array[0];

    }

}
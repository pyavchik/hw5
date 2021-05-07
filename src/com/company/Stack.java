package com.company;

import java.util.Objects;

public class Stack<E> implements Actionable<E> {
    public static final int STACK_SIZE = 10;
    private E[] array;
    private BlackList list;
    private int size;

    public Stack(BlackList list) {
        this.array = (E[]) new Object[STACK_SIZE];
        this.list = list;
        this.size = 0;
    }

    @Override
    public void push(E item) {
        if (item != null) {

            boolean isPresent = list.isPresent(item.getClass());

            if (!isPresent) {

                for (int i = 0; i < array.length; i++) {
                    if (Objects.isNull(array[i])) {
                        array[i] = item;
                        ++size;
                        break;
                    }
                }

            } else {
                throw new IllegalArgumentException("This class "
                        + item.getClass().getSimpleName()
                        + " is in blacklist");
            }

        } else {
            throw new IllegalArgumentException("Item can't be null");
        }
//        for (int i = 0; i < array.length; i++) {
//            if (Objects.isNull(array[i])) {
//                array[i] = item;
//                ++size;
//                break;
//            }
//        }

    }

    @Override
    public E delete() {
        if (size == 0) {
            throw new RuntimeException("Can't delete from empty Stack");
        }
        E item = array[size];

        array[size] = null;
        --size;

        return item;
    }

    @Override
    public E get() {
        if (size == 0) {
            throw new RuntimeException("Can't delete from empty Stack");

        }
        return array[size-1];

    }

}
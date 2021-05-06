package com.company;

public interface Actionable<E> {
    void push(E item);
    E delete();
    E get();
}

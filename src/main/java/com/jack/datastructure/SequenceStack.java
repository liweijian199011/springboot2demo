package com.jack.datastructure;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/11/27.
 *
 * @author liweijian.
 */
public class SequenceStack<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;

    private int capacityIncrement = 0;

    private Object[] elements;

    private int size = 0;

    public SequenceStack() {
        capacity = DEFAULT_CAPACITY;
        elements = new Object[capacity];
    }

    public SequenceStack(int initSize) {
        this.capacity = initSize;
        elements = new Object[initSize];
    }

    public SequenceStack(int initSize, int capacityIncrement) {
        this.capacity = initSize;
        this.capacityIncrement = capacityIncrement;
    }

    public int length() {
        return this.size;
    }

    public void push(T element) {
        elements[size++] = element;
    }
}

package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyStack() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public E push(E item) {
        if (size == elements.length) {
            ensureCapacity(size * 2);
        }
        elements[size++] = item;
        return item;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        E item = (E) elements[--size];
        elements[size] = null;
        return item;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        E item = (E) elements[size - 1];
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int search(E itemToFind) {
        for (int i = size - 1; i >= 0; i--) {
            @SuppressWarnings("unchecked")
            E item = (E) elements[i];
            if (item.equals(itemToFind)) {
                return size - i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(elements[i]).append(", ");
        }
        sb.append(elements[size - 1]).append("]");
        return sb.toString();
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}



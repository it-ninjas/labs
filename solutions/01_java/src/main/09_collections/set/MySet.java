package set;

import java.util.Arrays;
import java.util.Objects;

public class MySet<E> implements MySetInterfaceSimple<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MySet() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }
        if (size == elements.length) {
            // Vergrößern des Arrays, wenn es voll ist
            elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i],object)) {
                // Element gefunden, verschiebe die restlichen Elemente
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null; // Lösche das letzte Element
                return true;
            }
        }
        return false; // Element nicht gefunden
    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i],object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}


package set;

import java.util.Arrays;
import java.util.Objects;

public class MyHashSet<E> implements MySetInterfaceSimple<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyHashSet() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(E element) {
        if (contains(element)) {
            return false;
        }

        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }

        elements[size++] = new HashElement<>(element);
        return true;
    }

    @Override
    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            HashElement<E> hashElement = (HashElement<E>) elements[i];
            if (Objects.equals(hashElement.element, object)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        for (int i = 0; i < size; i++) {
            HashElement<E> hashElement = (HashElement<E>) elements[i];
            if (Objects.equals(hashElement.element, object)) {
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
            HashElement<E> hashElement = (HashElement<E>) elements[i];
            sb.append(hashElement.element);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static class HashElement<E> {
        private E element;
        private int hashCode;

        HashElement(E element) {
            this.element = element;
            this.hashCode = (element != null) ? element.hashCode() : 0;
        }
    }

}


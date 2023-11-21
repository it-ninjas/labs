package labs.a_basic_generics;

import java.util.ArrayList;
import java.util.List;

public class NumberList<T extends Number> {
    private final List<T> numbers;

    public NumberList() {
        numbers = new ArrayList<>();
    }

    public T get(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }

    public void add(T number) {
        numbers.add(number);
    }

    public void remove(int index) {
        numbers.remove(index);
    }

    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    public void clear() {
        numbers.clear();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public static void main(String[] args) {
        NumberList<Number> numberList = new NumberList<>();
        numberList.add(42);
        numberList.add(3.14);
        System.out.println("Number List: " + numberList);
    }
}

package labs.a_basic_generics;

public class GenericMethod {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4523, 23, 423, 42, 2, 3};
        String[] stringArray = {"Das", "ist", "ein", "cooler", "Text"};
        Double[] doubleArray = {12.320, 0.90, 523.532, 532467.2, 986.2001, 0.0000000001};
        printArray(intArray);
        printArray(stringArray);
        printArray(doubleArray);
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


}

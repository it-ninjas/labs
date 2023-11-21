package labs.b_library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library<T extends LibraryItem> {
    private final ArrayList<T> availableItems = new ArrayList<>();
    private final ArrayList<T> borrowedItems = new ArrayList<>();

    public void newItems(List<T> items) {
        availableItems.addAll(items);
    }

    public void returnItem(T item) {
        borrowedItems.remove(item);
        availableItems.add(item);
    }

    public Optional<T> checkoutItem(int serialNumber) {
        Optional<T> requestedItem = availableItems.stream()
                .filter(item -> item.hasSerialNumber(serialNumber))
                .findFirst();
        if (requestedItem.isEmpty()) {
            System.out.printf("No item with serial number %d found in the library\n", serialNumber);
            return Optional.empty();
        }
        return Optional.of(checkout(requestedItem.get()));
    }

    public void listAvailableItems() {
        if (availableItems.isEmpty()) {
            System.out.println("There are no available items in the library. Try again later :-)");
            return;
        }
        System.out.println("--- Available Items ---");
        availableItems.forEach(System.out::println);
        System.out.println("-----------------------");
    }

    public void listBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("All items are available in the Library. Nothing borrowed yet.");
            return;
        }
        System.out.println("--- Borrowed Items ---");
        borrowedItems.forEach(System.out::println);
        System.out.println("----------------------");
    }

    private T checkout(T item) {
        availableItems.remove(item);
        borrowedItems.add(item);
        return item;
    }

    @Override
    public String toString() {
        return "Library{" +
                "availableItems=" + availableItems +
                ", borrowedItems=" + borrowedItems +
                '}';
    }
}

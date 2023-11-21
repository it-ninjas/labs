package labs.b_library;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Library<Book> bookLibrary = createLibrary(books());
        Library<Journal> journalLibrary = createLibrary(journals());

        // should be all available, none borrowed
        printInventory(bookLibrary);
        printInventory(journalLibrary);

        // borrow a book
        Optional<Book> hobbit = bookLibrary.checkoutItem(2);
        printInventory(bookLibrary);
        // return the book
        hobbit.ifPresent(bookLibrary::returnItem);
        printInventory(bookLibrary);

        // borrow a journal
        Optional<Journal> javaMagazine = journalLibrary.checkoutItem(1);
        printInventory(journalLibrary);
        // return the journal
        javaMagazine.ifPresent(journalLibrary::returnItem);
        printInventory(journalLibrary);

        // try to borrow non-existing book
        Optional<Book> nonExistingBook = bookLibrary.checkoutItem(42);
        nonExistingBook.ifPresentOrElse(
                bookLibrary::returnItem,
                () -> System.out.println("Tried to retrieve non-existing book"));

        printLibrary(journalLibrary);
        printLibrary(bookLibrary);

    }

    //using unbounded wildcard
    private static void printLibrary(Library<?> library) {
        System.out.println("***************************");
        System.out.println("This is what this Library looks like: " + library);
        System.out.println("***************************");
    }

    // using upper bounded type parameter
    private static <T extends LibraryItem> Library<T> createLibrary(List<T> items) {
        Library<T> library = new Library<>();
        library.newItems(items);
        return library;
    }

    private static <T extends LibraryItem> void printInventory(Library<T> library) {
        library.listAvailableItems();
        library.listBorrowedItems();
    }

    private static List<Book> books() {
        return List.of(
                new Book(1, "Hitchhiker's guide to the galaxy", "Douglas Adams", "Fiction"),
                new Book(2, "The Hobbit", "J.R.R Tolkien", "Fantasy"),
                new Book(3, "The Lord of the Rings", "J.R.R Tolkien", "Fantasy")
        );
    }

    private static List<Journal> journals() {
        return List.of(
                new Journal(1, "Java Magazine", "Oracle", LocalDate.of(2022, 7, 1)),
                new Journal(2, "PC World", "International Data Group", LocalDate.of(2013, 8, 20)),
                new Journal(3, "Open Source For You", "EFY Enterprises Pvt. Ltd.", LocalDate.of(2003, 2, 15))
        );
    }
}

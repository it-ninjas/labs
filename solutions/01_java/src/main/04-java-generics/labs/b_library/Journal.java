package labs.b_library;

import java.time.LocalDate;

public class Journal extends LibraryItem {
    private final String publisher;
    private final LocalDate publicationDate;

    public Journal(int serialNumber, String title, String publisher, LocalDate publicationDate) {
        super(serialNumber, title);
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate;
    }
}

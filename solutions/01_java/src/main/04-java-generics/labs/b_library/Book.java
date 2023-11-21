package labs.b_library;

public class Book extends LibraryItem {
    private final String author;
    private final String genre;

    public Book(int serialNumber, String title, String author, String genre) {
        super(serialNumber, title);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'';
    }
}

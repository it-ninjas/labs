package labs.b_library;

import java.util.Objects;

public class LibraryItem {
    private final int serialNumber;
    private final String title;

    public LibraryItem(int serialNumber, String title) {
        this.serialNumber = serialNumber;
        this.title = title;
    }

    public boolean hasSerialNumber(int serialNumber) {
        return this.serialNumber == serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LibraryItem that = (LibraryItem) o;
        return serialNumber == that.serialNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return "Item of type " + this.getClass().getSimpleName() +
                ", serialNumber=" + serialNumber +
                ", title='" + title + '\'';
    }
}

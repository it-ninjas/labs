package ch.sbb.talentfactory.oop.exercises.d_immo;

public class Apartment {
    private final int storey;
    private final String apartmentNumber;
    private String description;

    public Apartment(int storey, String apartmentNumber, String description) {
        this.storey = storey;
        this.apartmentNumber = apartmentNumber;
        this.description = description;
    }

    public int getStorey() {
        return storey;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getDescription() {
        return description;
    }
}

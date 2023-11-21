package ch.sbb.talentfactory.oop.exercises.d_immo;

import java.util.List;

public class Property {
    private final List<Apartment> apartments;
    private final Address address;
    private Employee janitor;
    private Employee manager;

    public Property(List<Apartment> apartments, Address address, Employee janitor, Employee manager) {
        this.apartments = apartments;
        this.address = address;
        this.janitor = janitor;
        this.manager = manager;
    }

    public Address getAddress() {
        return address;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public Employee getJanitor() {
        return janitor;
    }

    public Employee getManager() {
        return manager;
    }
}

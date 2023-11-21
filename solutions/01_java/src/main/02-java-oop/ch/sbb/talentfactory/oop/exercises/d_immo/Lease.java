package ch.sbb.talentfactory.oop.exercises.d_immo;

import java.time.LocalDate;

public class Lease {
    private final Apartment apartment;
    private final Property property;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String issuerCompany;
    private final Tenant tenant;
    private final double rent;

    public Lease(Apartment apartment, Property property, LocalDate startDate, LocalDate endDate, double rent, String issuer, Tenant tenant) {
        this.apartment = apartment;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rent = rent;
        this.issuerCompany = issuer;
        this.tenant = tenant;
    }

    public Property getProperty() {
        return property;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getRent() {
        return rent;
    }

    public String getIssuerCompany() {
        return issuerCompany;
    }

    public Tenant getTenant() {
        return tenant;
    }
}

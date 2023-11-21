package ch.sbb.talentfactory.oop.exercises.d_immo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ninja-Immo creation
        Company ninjaImmo = new Company("Ninja-Immo", new Address("Bernstrasse", 69, 3018, "Bern"), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Employees of the Company which will be managers
        Employee steve = new Employee("Steve", "Miller", LocalDate.of(1990, Month.APRIL, 26), Gender.MALE);
        Employee isabelle = new Employee("Isabelle", "Clarkson", LocalDate.of(1960, Month.DECEMBER, 1), Gender.FEMALE);

        // Employees of the Company which will be janitors
        Employee ryan = new Employee("Ryan", "Garcia", LocalDate.of(2002, Month.MARCH, 19), Gender.OTHER);
        Employee karen = new Employee("Karen", "Jackson", LocalDate.of(1970, Month.AUGUST, 30), Gender.FEMALE);

        // Apartments of Property NinjaTower
        Apartment ninjaTowerA = new Apartment(0, "A", "3.5 Rooms, Ground-floor, Small garden, Renovated in 2021, 2 Bathrooms, Basement 1A included");
        Apartment ninjaTowerB = new Apartment(0, "B", "4.5 Rooms, Ground-floor, Big garden, Renovated in 2021, 2 Bathrooms, Basement 1B included");

        // create ninjaTowerApartments list
        List<Apartment> ninjaTowerApartments = new ArrayList<>();
        ninjaTowerApartments.add(ninjaTowerA);
        ninjaTowerApartments.add(ninjaTowerB);

        // creation NinjaTower
        Property ninjaTower = new Property(ninjaTowerApartments, new Address("Veilchenweg", 2, 3018, "Bern"), ryan, steve);

        // Apartments of Property SenseiCity
        Apartment senseiCityA = new Apartment(0, "A", "4.5 Rooms, Ground-floor, Small garden, Renovated in 1999, 2 Bathrooms, Basement A included, Known issues");
        Apartment senseiCityB = new Apartment(1, "B", "4.5 Rooms, Renovated in 1999, 2 Bathrooms, Basement B included");
        Apartment senseiCityC = new Apartment(2, "C", "4.5 Rooms, Renovated in 1999, 2 Bathrooms, Basement C included");
        Apartment senseiCityD = new Apartment(3, "D", "4.5 Rooms, Renovated in 2022, 2 Bathrooms, Basement D included");

        // Create SenseiCityApartments list
        List<Apartment> senseiCityApartments = new ArrayList<>();
        senseiCityApartments.add(senseiCityA);
        senseiCityApartments.add(senseiCityB);
        senseiCityApartments.add(senseiCityC);
        senseiCityApartments.add(senseiCityD);

        // creation SenseiCity
        Property senseiCity = new Property(senseiCityApartments, new Address("Muhlernstrasse", 1, 3098, "Köniz"), karen, isabelle);

        // Tenants for NinjaTower
        Tenant philippe = new Tenant("Philippe", "White", LocalDate.of(2000, Month.JANUARY, 27), Gender.MALE);
        Tenant autumn = new Tenant("Autumn", "Hunter", LocalDate.of(1965, Month.AUGUST, 30), Gender.FEMALE);

        // issue leases for NinjaTower
        ninjaImmo.issueLease(philippe, ninjaTowerA, ninjaTower, 1300, LocalDate.of(2021, Month.AUGUST, 1), LocalDate.of(2023, Month.SEPTEMBER, 1));
        ninjaImmo.issueLease(autumn, ninjaTowerB, ninjaTower, 1300, LocalDate.of(2022, Month.DECEMBER, 1), LocalDate.of(2024, Month.DECEMBER, 1));

        // Tenants for SenseiCity
        Tenant margot = new Tenant("Margot", "Robertson", LocalDate.of(1950, Month.OCTOBER, 7), Gender.FEMALE);
        Tenant kendal = new Tenant("Kendal", "Vargas", LocalDate.of(2001, Month.JULY, 19), Gender.FEMALE);
        Tenant julian = new Tenant("Julian", "Ritter", LocalDate.of(1983, Month.MAY, 23), Gender.MALE);

        // issue leases for SenseiCity
        ninjaImmo.issueLease(margot, senseiCityA, senseiCity, 1600, LocalDate.of(1990, Month.NOVEMBER, 1), LocalDate.of(2028, Month.NOVEMBER, 1));
        ninjaImmo.issueLease(kendal, senseiCityD, senseiCity, 2300, LocalDate.of(2023, Month.MAY, 1), LocalDate.of(2026, Month.MAY, 1));
        ninjaImmo.issueLease(julian, senseiCityB, senseiCity, 1700, LocalDate.of(1990, Month.FEBRUARY, 1), LocalDate.of(2030, Month.FEBRUARY, 1));

        // Add Properties to Company
        ninjaImmo.addProperty(ninjaTower);
        ninjaImmo.addProperty(senseiCity);

        // Add Employees to Company
        ninjaImmo.addEmployee(steve);
        ninjaImmo.addEmployee(isabelle);
        ninjaImmo.addEmployee(ryan);
        ninjaImmo.addEmployee(karen);

        // Testing the methods
        System.out.println("There are a total of " + ninjaImmo.getNumberOfApartments() + " Apartments owned by this Company.");

        System.out.println("The Janitor of your Apartment is " + ninjaImmo.getJanitorForApartment(senseiCityA).getFullName());

        List<Lease> leasesOfSenseiCity = ninjaImmo.getLeasesOfProperty(senseiCity);

        System.out.println("There are a total of " + ninjaImmo.getNumberOfEmptyApartments() + " Empty Apartments owned by this Company.");

        List<Lease> expiringLeases = ninjaImmo.getExpiringLeases();

        List<Lease> sortedLeases = ninjaImmo.getSortedLeases();

        System.out.println("The Property is generating a monthly income of " + ninjaImmo.getMonthlyIncomeByProperty(senseiCity));

        System.out.println("The Company will generate an income of " + ninjaImmo.getTotalYearlyIncome() + " this year");
    }
}

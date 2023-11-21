package ch.sbb.talentfactory.oop.exercises.d_immo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {

    private final String name;
    private final Address headquarters;
    private final List<Property> properties;
    private final List<Employee> employees;
    private final List<Lease> leases;


    public Company(String name, Address headquarters, List<Property> properties, List<Employee> employees, List<Lease> leases) {
        this.name = name;
        this.headquarters = headquarters;
        this.properties = properties;
        this.employees = employees;
        this.leases = leases;
    }

    public String getName() {
        return name;
    }

    public Address getHeadquarters() {
        return headquarters;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        this.properties.add(property);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Lease> getLeases() {
        return leases;
    }

    public Lease issueLease(Tenant tenant, Apartment apartment, Property property, double rent, LocalDate moveIn, LocalDate moveOut) {
        Lease lease = new Lease(apartment, property, moveIn, moveOut, rent, this.getName(), tenant);
        this.leases.add(lease);
        return lease;
    }

    public int getNumberOfApartments() {
        int count = 0;
        for (Property p : this.properties) {
            count += p.getApartments().size();
        }
        return count;
    }

    public Employee getJanitorForApartment(Apartment apartment) {
        Employee janitorForApartment = null;
        for (Property p : this.properties) {
            if (p.getApartments().contains(apartment)) {
                janitorForApartment = p.getJanitor();
                break;
            }
        }
        return janitorForApartment;
    }

    public List<Lease> getLeasesOfProperty(Property property) {
        List<Lease> leasesOfProperty = new ArrayList<>();
        for (Lease lease : this.leases) {
            if (lease.getProperty().equals(property)) {
                leasesOfProperty.add(lease);
            }
        }
        return leasesOfProperty;
    }

    public int getNumberOfEmptyApartments() {
        List<Apartment> allApartments = new ArrayList<>();
        for (Property p : this.properties) {
            allApartments.addAll(p.getApartments());
        }
        List<Apartment> apartmentsWithLease = new ArrayList<>();
        for (Lease lease : this.leases) {
            apartmentsWithLease.add(lease.getApartment());
        }
        return allApartments.size() - apartmentsWithLease.size();
    }


    public List<Lease> getExpiringLeases() {
        List<Lease> expiringLeases = new ArrayList<>();
        for (Lease lease : this.leases) {
            Period differenceNowAndEnd = Period.between(LocalDate.now(), lease.getEndDate());
            if (differenceNowAndEnd.getMonths() == 0 || (differenceNowAndEnd.getMonths() == 1 && differenceNowAndEnd.getDays() == 0)) {
                expiringLeases.add(lease);
            }
        }
        return expiringLeases;
    }

    // Leases get sorted by person, a person can have more than one Lease
    public List<Lease> getSortedLeases() {
        leases.sort(Comparator.comparing(lease -> lease.getTenant().getFullName()));
        return leases;
    }

    public double getMonthlyIncomeByProperty(Property property) {
        double montlyIncome = 0d;
        for (Lease lease : this.leases) {
            if (lease.getProperty().equals(property)) {
                montlyIncome += lease.getRent();
            }
        }
        return montlyIncome;
    }

    public double getTotalYearlyIncome() {
        LocalDate now = LocalDate.now();
        double yearlyIncome = 0d;
        for (Lease lease : this.leases) {
            if (lease.getEndDate().getYear() == now.getYear()) {
                yearlyIncome += lease.getRent() * lease.getEndDate().getMonth().getValue();
            } else {
                yearlyIncome += lease.getRent() * 12;
            }
        }
        return yearlyIncome;
    }
}

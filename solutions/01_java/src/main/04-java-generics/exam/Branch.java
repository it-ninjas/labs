package exam;

import java.util.List;

public class Branch {
    private String name;
    private List<Shelf> shelves;
    private List<Employee> employees;
    private boolean hasSelfservice;

    public Branch(String name, List<Shelf> shelves, boolean hasSelfservice, List<Employee> employees) {
        this.name = name;
        this.shelves = shelves;
        this.hasSelfservice = hasSelfservice;
        this.employees = employees;
    }

    public boolean hasSelfservice() {
        return hasSelfservice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public void addShelf(Shelf shelf) {
        shelves.add(shelf);
    }

    public void setHasSelfservice(boolean hasSelfservice) {
        this.hasSelfservice = hasSelfservice;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addBranchEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeBranchEmployee(Employee employee) {
        employees.remove(employee);
    }
}

package exam;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> branchAEmployees = new ArrayList<>();
        List<Employee> branchBEmployees = new ArrayList<>();

        Employee hans = new Employee("Hans");
        Employee peter = new Employee("Peter");
        Employee dieter = new Employee("Dieter");
        Employee lina = new Employee("Lina");

        branchAEmployees.add(hans);

        branchBEmployees.add(peter);
        branchBEmployees.add(dieter);

        Branch a = new Branch("A", new ArrayList<>(), true, branchAEmployees);
        Branch b = new Branch("B", new ArrayList<>(), true, branchBEmployees);

        List<Branch> branches = new ArrayList<>();
        branches.add(a);
        branches.add(b);

        Coop coop = new Coop(branches);

        List<Employee> resultAllEmployees = coop.getAllEmployees();

        Branch branchOfPeter = coop.findEmployeeBranch(peter);
        Branch branchOfLina = coop.findEmployeeBranch(lina); // should be null

        System.out.println();

    }
}

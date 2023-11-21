package ch.sbb.talentfactory.oop.exercises.a_patient;

import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final List<Patient> patients = new LinkedList<>();

    public static void main(String[] args) {
        patients.add(new Patient("Alex"));
        patients.add(new Patient("Benj"));
        patients.add(new Patient("Cori"));
        patients.get(0).makeCheckUp(175, 75, 36.1, true);
        patients.get(1).makeCheckUp(180, 81, 36.9, true);
        patients.get(2).makeCheckUp(183, 93, 38.1, false);
        addressBook(patients.get(0));
        addressBook(patients.get(1));
        addressBook(patients.get(2));
    }

    private static void addressBook(Patient patient) {
        System.out.printf("Patient's height is %scm\n", patient.getHeight());
        System.out.printf("Patient's weight is %scm\n", patient.getWeight());
        System.out.printf("Patient's temperature is %scm\n", patient.getTemperature());
        System.out.printf("Patient is %svaccinated\n", patient.isVaccinated() ? "" : "not ");
        System.out.println();
    }
}

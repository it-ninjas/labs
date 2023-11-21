package ch.sbb.talentfactory.oop.exercises.a_patient;

public class Patient {
    private String name;
    private Integer height;
    private double weight;
    private double temperature;
    private boolean vaccinated;

    public Patient(String name) {
        this.name = name;
    }

    public void makeCheckUp(Integer height, double weight, double temperature, boolean vaccinated) {
        this.height = height;
        this.weight = weight;
        this.temperature = temperature;
        this.vaccinated = vaccinated;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public boolean isVaccinated() {
        return this.vaccinated;
    }

    public Integer getHeight() {
        return this.height;
    }

}

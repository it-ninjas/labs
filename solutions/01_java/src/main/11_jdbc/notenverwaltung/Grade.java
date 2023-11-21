package notenverwaltung;

import java.time.LocalDate;

public class Grade {
    private int grade_id;
    private double grade;
    private LocalDate date;

    public Grade(int grade_id, double grade, LocalDate date) {
        this.grade_id = grade_id;
        this.grade = grade;
        this.date = date;
    }

    public Grade() {
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Grade ID: " + grade_id + "\n" +
                "Grade: " + grade + "\n" +
                "Date: " + date;
    }
}

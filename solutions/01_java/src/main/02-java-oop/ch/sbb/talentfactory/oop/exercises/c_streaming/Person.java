package ch.sbb.talentfactory.oop.exercises.c_streaming;


import java.util.LinkedList;
import java.util.List;

public class Person {

    private final String name;
    private final String emailAddress;
    private final boolean monthlyPayment;
    private final List<Movie> viewedMovies = new LinkedList<>();
    private String creditCard;

    public Person(String name, String emailAddress, String creditCard, boolean monthlyPayment) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.creditCard = creditCard;
        this.monthlyPayment = monthlyPayment;
    }

    public void addMovieToViewed(Movie movie) {
        if (this.viewedMovies.stream().noneMatch(o -> o.equals(movie))) {
            this.viewedMovies.add(movie);
            movie.addViewOfUser();
        }
    }

    public void changePayment(String newCreditCard) {
        this.creditCard = newCreditCard;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public boolean isMonthlyPayment() {
        return monthlyPayment;
    }

    public void printCardInformation() {
        System.out.printf("Person: %s ; Creditcard: %s\n", this.emailAddress, this.creditCard);
    }
}

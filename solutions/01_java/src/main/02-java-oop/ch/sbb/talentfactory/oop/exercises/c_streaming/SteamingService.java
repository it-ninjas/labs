package ch.sbb.talentfactory.oop.exercises.c_streaming;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class SteamingService {

    private final List<Person> people = new LinkedList<>();
    private final List<Movie> movies = new LinkedList<>();

    public Integer getTotalSubscriber() {
        return this.people.size();
    }

    public boolean newPerson(Person person) {
        if (this.people.stream().noneMatch(o -> o.getEmailAddress().equals(person.getEmailAddress()))) {
            this.people.add(person);
            return true;
        }
        System.out.printf("Person with this email %s already exists\n", person.getEmailAddress());
        return false;
    }

    public boolean deletePerson(String email) {
        if (!this.people.removeIf(person -> person.getEmailAddress().equals(email))) {
            System.out.printf("No Person with email %s found\n", email);
            return true;
        }
        return false;
    }

    public boolean newMovie(Movie movie) {
        if (this.movies.stream().noneMatch(o -> o.equals(movie))) {
            this.movies.add(movie);
            return true;
        }
        System.out.printf("Movie %s already exists\n", movie.getName());
        return false;
    }

    public boolean deleteMovie(Movie movie) {
        if (!this.movies.removeIf(m -> m.equals(movie))) {
            System.out.printf("No Movie with name %s found\n", movie.getName());
            return true;
        }
        return false;
    }

    public List<Movie> findMoviesByName(String name) {
        List<Movie> found = this.movies.stream().filter(o -> o.getName().contains(name)).collect(Collectors.toList());
        if (found.size() == 0) {
            System.out.printf("No Movie with name %s found\n", name);
        }
        return found;
    }

    public List<Movie> findMoviesByGenre(Genre genre) {
        List<Movie> found = this.movies.stream().filter(o -> o.getGenres().contains(genre)).collect(Collectors.toList());
        if (found.size() == 0) {
            System.out.printf("No Movie with genre %s found\n", genre);
        }
        return found;
    }

    public Integer getViewsOfMovie(Movie movie) {
        return movie.getViews();
    }

    public void billing(boolean yearly) {
        System.out.printf("Printing %s billing\n", yearly ? "yearly" : "monthly");
        for (Person person : people) {
            if (person.isMonthlyPayment() == yearly) {
                person.printCardInformation();
            }
        }
        System.out.println();
    }

    public Person findPersonByEmail(String email) {
        Optional<Person> person = this.people.stream().filter(o -> o.getEmailAddress().equals(email)).findFirst();
        if (person.isEmpty()) {
            System.out.printf("No person with email %s found\n", email);
            return null;
        }
        return person.get();
    }
}

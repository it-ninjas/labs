package ch.sbb.talentfactory.oop.exercises.c_streaming;


import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        SteamingService steamingService = new SteamingService();
        steamingService.newPerson(new Person("Sven", "sven.jaun2@sbb.ch", "4988438843884305 03/2030 737", false));
        steamingService.newPerson(new Person("Claudio", "claudio.zesiger@sbb.ch", "4166676667666746 03/2030 737", true));
        steamingService.newPerson(new Person("Ruzo", "ruzo.madem@google.cz", "4646464646464644 03/2030 737", true));
        steamingService.newPerson(new Person("Sven", "sven.bruegger@sbb.ch", "4000620000000007 03/2030 737", false));

        steamingService.newMovie(new Movie("The Bee Movie", 91, Arrays.asList(Genre.COMEDY, Genre.HISTORY), "Jerry Seinfeld"));
        steamingService.newMovie(new Movie("The Human Centipede", 92, Arrays.asList(Genre.COMEDY, Genre.ROMANCE, Genre.FAMILY), "Ilona Six"));
        steamingService.newMovie(new Movie("Deadpool", 108, Arrays.asList(Genre.STONER, Genre.CIRCUS), "Simon Kinberg"));
        steamingService.newMovie(new Movie("Space Jam: A New Legacy", 115, Arrays.asList(Genre.PROPAGANDA, Genre.WAR), "Malcolm D. Lee"));

        System.out.printf("%s persons subscribed to out streaming service\n", steamingService.getTotalSubscriber());
        steamingService.deletePerson("sven.bruegger@sbb.ch");
        System.out.printf("%s persons subscribed to out streaming service\n", steamingService.getTotalSubscriber());

        System.out.println("findMoviesByName(\"The\")");
        for (Movie movie : steamingService.findMoviesByName("The")) {
            System.out.println("Found movie:");
            printMovie(movie);
        }


        System.out.println("findMoviesByGenre(Genre.COMEDY)");
        for (Movie movie : steamingService.findMoviesByGenre(Genre.COMEDY)) {
            System.out.println("Found movie:");
            printMovie(movie);
        }


        for (Movie movie : steamingService.findMoviesByName("The Human Centipede")) {
            steamingService.findPersonByEmail("sven.jaun2@sbb.ch").addMovieToViewed(movie);
            steamingService.findPersonByEmail("claudio.zesiger@sbb.ch").addMovieToViewed(movie);
            System.out.printf("Viewcount of the movie \"%s\" is: %s\n", movie.getName(), movie.getViews());
        }

        steamingService.billing(false);


        steamingService.findPersonByEmail("claudio.zesiger@sbb.ch").changePayment("4000620000000007 03/2030 737");

        steamingService.billing(true);

    }

    private static void printPerson(Person person) {
        System.out.printf("Person's name is %s\n", person.getName());
        System.out.printf("Person's e-mail is %s\n", person.getEmailAddress());
        System.out.printf("Person's payment %s\n", person.isMonthlyPayment() ? "monthly" : "yearly");
        System.out.println();
    }

    private static void printMovie(Movie movie) {
        System.out.printf("Movie's name is %s\n", movie.getName());
        System.out.printf("Movie's duration is %s\n", movie.getDuration());
        System.out.printf("Movie's Genres are: %s\n", movie.getGenres().stream().map(e -> e.toString() + ", ").collect(Collectors.joining()).replaceAll("..$", ""));
        System.out.printf("Movie's producer is: %s\n", movie.getProducer());
        System.out.println();
    }
}

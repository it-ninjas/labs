package ch.sbb.talentfactory.oop.exercises.c_streaming;


import java.util.List;
import java.util.Objects;

public class Movie {
    private final String name;
    private final Integer duration;
    private final List<Genre> genres;
    private final String producer;
    private Integer views = 0;

    public Movie(String name, Integer duration, List<Genre> genres, String producer) {
        this.name = name;
        this.duration = duration;
        this.genres = genres;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getProducer() {
        return producer;
    }

    public Integer getViews() {
        return views;
    }

    public void addViewOfUser() {
        this.views++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(duration, movie.duration) &&
                Objects.equals(producer, movie.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, producer, views);
    }
}

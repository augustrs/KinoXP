package com.example.kinoxp;

import com.example.kinoxp.model.Movie;
import com.example.kinoxp.model.Tags;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KinoRepository {
    private List<Movie> movies;
    private BookingService bookingService;

    public KinoRepository(BookingService bookingService) {
        this.bookingService = bookingService;
        this.movies = new ArrayList<>(List.of(
                new Movie(1L, "Interstellar", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", 2015, "Christopher Nolan", 2.5, List.of("Matthew McConaughey"), "https://static.posters.cz/image/750/plakater/interstellar-ice-walk-i23290.jpg", List.of(Tags.Science_fiction, Tags.Drama, Tags.Alder15), "2LqzF5WauAw"),
                new Movie(2L, "The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", 1994, "Frank Darabont", 2.2, List.of("Tim Robbins", "Morgan Freeman"), "https://m.media-amazon.com/images/I/71715eBi1sL.jpg", List.of(Tags.Drama, Tags.Alder15), "PLl99DlL6b4"),
                new Movie(3L, "Anyone but You", "Two people who hate each other pretend to be a couple for everyone around them.", 2023, "Will Gluck", 1.8, List.of("Sydney Sweeney", "Glen Powell"), "https://postercinema.eu/cdn/shop/files/anyone-but-you_6g14mtbh_47b8b600-1740-4cab-970a-00c7b01a98a6.jpg?v=1706648834", List.of(Tags.Comedy, Tags.Romance, Tags.Alder15), "S61xB-rE770")
        ));

        bookingService.setMovies(movies);
        bookingService.createScreeningsForNextNinetyDays();
    }

    public List<Movie> getMovies() {
        return movies;
    }
    public Movie addMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }
    public Movie editMovie(Movie movie) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId().equals(movie.getId())) {
                movies.set(i, movie);
                return movie;
            }
        }
        return null;
    }
    public void deleteMovie(Long id) {
        movies.removeIf(movie -> movie.getId().equals(id));
    }
}

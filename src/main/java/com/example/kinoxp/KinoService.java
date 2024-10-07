package com.example.kinoxp;

import com.example.kinoxp.model.Movie;
import com.example.kinoxp.model.Screening;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KinoService {
    private KinoRepository kinoRepository;
    private BookingService bookingService;

    public KinoService(KinoRepository kinoRepository, BookingService bookingService) {
        this.kinoRepository = kinoRepository;
        this.bookingService = bookingService;
    }

    public List<Movie> getMovies() {
        return kinoRepository.getMovies();
    }

    public Movie getMovieById(Long id) {
        return kinoRepository.getMovies().stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public List<Screening> getScreeningsForMovie(Long movieId) {
        Movie movie = getMovieById(movieId);
        return movie.getScreenings();
    }
}

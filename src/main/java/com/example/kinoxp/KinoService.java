package com.example.kinoxp;


import com.example.kinoxp.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KinoService {
    private KinoRepository kinoRepository;

    public KinoService(KinoRepository kinoRepository) {
        this.kinoRepository = new KinoRepository();
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
}

package com.example.kinoxp;


import com.example.kinoxp.model.Movie;
import com.example.kinoxp.model.Tags;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class KinoRepository {
    List<Movie> movies = List.of(new Movie(1L,
            "Interstellar",
            "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            2015, "Christopher Nolan",
            2.5,List.of("Matthew McConaughey"),
            "https://static.posters.cz/image/750/plakater/interstellar-ice-walk-i23290.jpg",
            List.of(Tags.Science_fiction, Tags.Drama, Tags.Alder15)));


    public List<Movie> getMovies() {
        return movies;
    }
}

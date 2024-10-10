package com.example.kinoxp;

import com.example.kinoxp.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class KinoController {
    private KinoService kinoService;

    public KinoController(KinoService kinoService) {
        this.kinoService = kinoService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("movies", kinoService.getMovies());
        return "index";
    }

    @GetMapping("/movie/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        model.addAttribute("movie", kinoService.getMovieById(id));
        return "movie-details";
    }

    @GetMapping("/movies")
    public String showAllMovies(Model model) {
        model.addAttribute("movies", kinoService.getMovies());
        return "all-movies";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/manage-movies")
    public String manageMoviesPage(Model model) {
        model.addAttribute("movies", kinoService.getMovies());
        return "manage-movies";
    }

    @PostMapping("/add-movie")
    public String addMovie(@ModelAttribute Movie movie) {
        kinoService.addMovie(movie);
        return "redirect:/manage-movies";
    }

    @GetMapping("/edit-movie/{id}")
    public String editMovieForm(@PathVariable Long id, Model model) {
        Movie movie = kinoService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "edit-movie";
    }

    @PostMapping("/edit-movie/{id}")
    public String editMovie(@PathVariable Long id, @ModelAttribute Movie movie) {
        Movie existingMovie = kinoService.getMovieById(id);

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setYear(movie.getYear());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setTime(movie.getTime());
        existingMovie.setActors(movie.getActors());
        existingMovie.setImage(movie.getImage());
        existingMovie.setTags(movie.getTags());
        existingMovie.setYoutubeVideoId(movie.getYoutubeVideoId());

        kinoService.editMovie(existingMovie);
        return "redirect:/manage-movies";
    }


    @GetMapping("/delete-movie/{id}")
    public String deleteMovie(@PathVariable Long id) {
        kinoService.deleteMovie(id);
        return "redirect:/manage-movies";
    }

}

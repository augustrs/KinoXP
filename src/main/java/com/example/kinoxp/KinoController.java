package com.example.kinoxp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class KinoController {
    private KinoService kinoService;

    public KinoController(KinoService kinoService) {
        this.kinoService = kinoService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("movies" , kinoService.getMovies());
        return "index";
    }
    @GetMapping("/movie/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        model.addAttribute("movie", kinoService.getMovieById(id));
        return "movie-details";
    }
}

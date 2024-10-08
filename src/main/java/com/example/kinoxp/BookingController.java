package com.example.kinoxp;

import com.example.kinoxp.model.Movie;
import com.example.kinoxp.model.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/book/{movieId}")
    public String bookMovie(@PathVariable Long movieId, Model model) {
        Movie movie = bookingService.getMovieById(movieId);
        if (movie == null) {
            return "redirect:/movies";
        }
        List<Screening> screenings = movie.getUpcomingScreenings();
        model.addAttribute("movie", movie);
        model.addAttribute("screenings", screenings);
        return "booking";
    }

    @GetMapping("/book/{movieId}/{screeningId}")
    public String selectSeats(@PathVariable Long movieId, @PathVariable Long screeningId, Model model) {
        Movie movie = bookingService.getMovieById(movieId);
        Screening screening = bookingService.getScreeningById(screeningId);

        if (movie == null || screening == null) {
            return "redirect:/movies";
        }

        String seatingArrangement = bookingService.getSeatingArrangement(screeningId);
        model.addAttribute("movie", movie);
        model.addAttribute("screening", screening);
        model.addAttribute("seatingArrangement", seatingArrangement);
        return "booking";
    }

    @PostMapping("/book/{movieId}/{screeningId}")
    public String processBooking(@PathVariable Long movieId,
                                 @PathVariable Long screeningId,
                                 @RequestParam int numberOfTickets,
                                 @RequestParam(required = false) List<String> extras,
                                 @RequestParam List<String> selectedSeats,
                                 Model model) {
        Movie movie = bookingService.getMovieById(movieId);
        Screening screening = bookingService.getScreeningById(screeningId);

        if (movie == null || screening == null) {
            return "redirect:/movies";
        }

        boolean bookingSuccess = bookingService.reserveSeats(screeningId, selectedSeats);
        double totalPrice = bookingService.calculateTotalPrice(numberOfTickets, extras);

        if (bookingSuccess) {
            model.addAttribute("movie", movie);
            model.addAttribute("screening", screening);
            model.addAttribute("numberOfTickets", numberOfTickets);
            model.addAttribute("extras", extras);
            model.addAttribute("selectedSeats", selectedSeats);
            model.addAttribute("totalPrice", totalPrice);
            return "bookingConfirmation";
        } else {
            model.addAttribute("error", "Booking failed. Please try again.");
            model.addAttribute("movie", movie);
            model.addAttribute("screenings", movie.getUpcomingScreenings());
            return "booking";
        }
    }
}

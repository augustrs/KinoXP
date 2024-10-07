package com.example.kinoxp;

import com.example.kinoxp.model.Movie;
import com.example.kinoxp.model.Screening;
import com.example.kinoxp.model.Tags;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        bookingService = new BookingService();
        List<Movie> movies = List.of(
                new Movie(1L, "Test Movie 1", "Description 1", 2021, "Director 1", 2.0, List.of("Actor 1"), "image1.jpg", List.of(Tags.Action), "video1"),
                new Movie(2L, "Test Movie 2", "Description 2", 2022, "Director 2", 2.5, List.of("Actor 2"), "image2.jpg", List.of(Tags.Comedy), "video2")
        );
        bookingService.setMovies(movies);
    }

    @Test
    void testCreateScreeningsForNextNinetyDays() {
        bookingService.createScreeningsForNextNinetyDays();

        // Test for the first movie
        Movie movie1 = bookingService.getMovies().get(0);
        List<Screening> screenings1 = movie1.getScreenings();

        // Test for the second movie
        Movie movie2 = bookingService.getMovies().get(1);
        List<Screening> screenings2 = movie2.getScreenings();

        // Assert that screenings were created
        assertFalse(screenings1.isEmpty(), "Screenings should not be empty for movie 1");
        assertFalse(screenings2.isEmpty(), "Screenings should not be empty for movie 2");

        // Assert that screenings were created for 90 days
        LocalDate lastScreeningDate = screenings1.get(screenings1.size() - 1).getStartTime().toLocalDate();
        assertEquals(LocalDate.now().plusDays(89), lastScreeningDate, "Last screening should be 89 days from today");

        // Assert that there are 10 screenings per day (5 for each of the 2 halls)
        assertEquals(90 * 10, screenings1.size() + screenings2.size(), "There should be 900 screenings in total");

        // Print some information for manual verification
        System.out.println("Total screenings created: " + (screenings1.size() + screenings2.size()));
        System.out.println("First screening date: " + screenings1.get(0).getStartTime());
        System.out.println("Last screening date: " + screenings1.get(screenings1.size() - 1).getStartTime());
    }
}
package com.example.kinoxp;

import com.example.kinoxp.model.CinemaHall;
import com.example.kinoxp.model.Movie;
import com.example.kinoxp.model.Screening;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private List<CinemaHall> cinemaHalls;
    private List<Movie> movies;

    public BookingService() {
        this.cinemaHalls = new ArrayList<>();
        this.cinemaHalls.add(new CinemaHall("A", 240));
        this.cinemaHalls.add(new CinemaHall("B", 400));
        this.movies = new ArrayList<>();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void createScreeningsForNextNinetyDays() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(90);

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            createScreeningsForDate(date);
        }
    }

    private void createScreeningsForDate(LocalDate date) {
        LocalTime[] screeningTimes = {
                LocalTime.of(10, 0),
                LocalTime.of(13, 0),
                LocalTime.of(16, 0),
                LocalTime.of(19, 0),
                LocalTime.of(22, 0)
        };

        for (CinemaHall hall : cinemaHalls) {
            for (LocalTime time : screeningTimes) {
                LocalDateTime screeningDateTime = LocalDateTime.of(date, time);
                Movie movie = getRandomMovie();
                Screening screening = new Screening(generateScreeningId(), movie, hall, screeningDateTime);
                movie.addScreening(screening);
            }
        }
    }

    private Movie getRandomMovie() {
        int randomIndex = (int) (Math.random() * movies.size());
        return movies.get(randomIndex);
    }

    private Long generateScreeningId() {
        return System.currentTimeMillis();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Movie getMovieById(Long id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Screening getScreeningById(Long id) {
        return movies.stream()
                .flatMap(movie -> movie.getScreenings().stream())
                .filter(screening -> screening.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean processBooking(Long screeningId, int numberOfTickets, List<String> extras, String selectedSeats) {
        Screening screening = getScreeningById(screeningId);
        if (screening != null && screening.getAvailableSeats() >= numberOfTickets) {
            screening.setAvailableSeats(screening.getAvailableSeats() - numberOfTickets);
            // In a real application, you would save the booking details here
            return true;
        }
        return false;
    }
}
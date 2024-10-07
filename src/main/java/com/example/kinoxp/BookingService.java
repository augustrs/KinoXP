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

@Service
public class BookingService {
    private List<CinemaHall> cinemaHalls;
    private List<Movie> movies;

    public BookingService() {
        this.cinemaHalls = new ArrayList<>();
        this.cinemaHalls.add(new CinemaHall("A", 240, 20, 12)); // Smallest theater
        this.cinemaHalls.add(new CinemaHall("B", 400, 25, 16)); // Largest theater
        this.movies = new ArrayList<>();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void createScreeningsForNextNinetyDays() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(90);

        for (Movie movie : movies) {
            for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
                createScreeningsForMovieAndDate(movie, date);
            }
        }
    }

    private void createScreeningsForMovieAndDate(Movie movie, LocalDate date) {
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
                Screening screening = new Screening(movie, hall, screeningDateTime);
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

    public Screening getScreeningById(Long screeningId) {
        for (Movie movie : movies) {
            for (Screening screening : movie.getScreenings()) {
                if (screening.getId().equals(screeningId)) {
                    return screening;
                }
            }
        }
        return null;
    }

    public boolean reserveSeats(Long screeningId, List<String> selectedSeats) {
        Screening screening = getScreeningById(screeningId);
        if (screening != null) {
            synchronized (screening) {
                for (String seat : selectedSeats) {
                    int row = seat.charAt(0) - 'A';
                    int col = Integer.parseInt(seat.substring(1)) - 1;
                    if (!screening.isSeatAvailable(row, col)) {
                        return false; // Seat already taken
                    }
                }
                for (String seat : selectedSeats) {
                    int row = seat.charAt(0) - 'A';
                    int col = Integer.parseInt(seat.substring(1)) - 1;
                    screening.reserveSeat(row, col);
                }
                return true;
            }
        }
        return false;
    }

    public double calculateTotalPrice(int numberOfTickets, List<String> extras) {
        double basePrice = 10.0; // Base ticket price
        double totalPrice = numberOfTickets * basePrice;

        if (extras != null) {
            for (String extra : extras) {
                switch (extra) {
                    case "popcorn":
                        totalPrice += 5.0;
                        break;
                    case "soda":
                        totalPrice += 3.0;
                        break;
                }
            }
        }

        return totalPrice;
    }

    public String getSeatingArrangement(Long screeningId) {
        Screening screening = getScreeningById(screeningId);
        if (screening != null) {
            boolean[][] seats = screening.getSeats();
            StringBuilder sb = new StringBuilder();
            for (boolean[] row : seats) {
                for (boolean seat : row) {
                    sb.append(seat ? "1" : "0");
                }
            }
            return sb.toString();
        }
        return "";
    }
}

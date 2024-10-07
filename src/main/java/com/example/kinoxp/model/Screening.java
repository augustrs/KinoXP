package com.example.kinoxp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screening {
    private static long idCounter = 1;
    private Long id;
    private Movie movie;
    private CinemaHall hall;
    private LocalDateTime startTime;
    private boolean[][] seats;

    public Screening(Movie movie, CinemaHall hall, LocalDateTime startTime) {
        this.id = idCounter++;
        this.movie = movie;
        this.hall = hall;
        this.startTime = startTime;
        this.seats = new boolean[hall.getRows()][hall.getSeatsPerRow()];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getHall() {
        return hall;
    }

    public void setHall(CinemaHall hall) {
        this.hall = hall;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public boolean[][] getSeats() {
        return seats;
    }

    public void setSeats(boolean[][] seats) {
        this.seats = seats;
    }

    public boolean isSeatAvailable(int row, int col) {
        return !seats[row][col];
    }

    public void reserveSeat(int row, int col) {
        seats[row][col] = true;
    }

    public String getFormattedStartTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return startTime.format(formatter);
    }
}

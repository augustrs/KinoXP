package com.example.kinoxp.model;

import com.example.kinoxp.model.CinemaHall;
import com.example.kinoxp.model.Movie;

import java.time.LocalDateTime;

public class Screening {
    private Long id;
    private Movie movie;
    private CinemaHall hall;
    private LocalDateTime startTime;
    private int availableSeats;

    public Screening(Long id, Movie movie, CinemaHall hall, LocalDateTime startTime) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startTime = startTime;
        this.availableSeats = hall.getCapacity();
    }

    // Getters and setters
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
package com.example.kinoxp.model;

import java.time.LocalDateTime;

public class CinemaHall {
    private String name;
    private int capacity;

    public CinemaHall(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
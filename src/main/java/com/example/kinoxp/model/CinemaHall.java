package com.example.kinoxp.model;

public class CinemaHall {
    private String name;
    private int capacity;
    private int rows;
    private int seatsPerRow;

    public CinemaHall(String name, int capacity, int rows, int seatsPerRow) {
        this.name = name;
        this.capacity = capacity;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }
}

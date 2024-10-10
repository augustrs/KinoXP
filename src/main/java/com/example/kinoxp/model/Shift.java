package com.example.kinoxp.model;

public class Shift {

    private String workerName;
    private int day;
    private String startTime;
    private String endTime;

    public Shift(String workerName, int day, String startTime, String endTime) {
        this.workerName = workerName;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getWorkerName() {
        return workerName;
    }

    public int getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

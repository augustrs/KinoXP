package com.example.kinoxp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Movie {
    private String youtubeVideoId;
    private String title;
    private String description;
    private int year;
    private String director;
    private double time;
    private List<String> actors;
    private String image;
    private List<Tags> tags;
    private Long id;
    private List<Screening> screenings;

    public Movie(Long id, String title, String description, int year, String director, double time, List<String> actors, String image, List<Tags> tags, String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.director = director;
        this.time = time;
        this.actors = actors;
        this.image = image;
        this.tags = tags;
        this.screenings = new ArrayList<>();
    }

    public String getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    public void addScreening(Screening screening) {
        this.screenings.add(screening);
    }

    public List<Screening> getUpcomingScreenings() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime threeMonthsLater = now.plusMonths(3);
        return screenings.stream()
                .filter(s -> s.getStartTime().isAfter(now) && s.getStartTime().isBefore(threeMonthsLater))
                .sorted(Comparator.comparing(Screening::getStartTime))
                .collect(Collectors.toList());
    }
}

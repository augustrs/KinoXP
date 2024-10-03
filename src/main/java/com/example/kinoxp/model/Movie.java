package com.example.kinoxp.model;

import java.util.List;

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
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public double getTime() {
        return time;
    }

    public List<String> getActors() {
        return actors;
    }

    public String getImage() {
        return image;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }
}

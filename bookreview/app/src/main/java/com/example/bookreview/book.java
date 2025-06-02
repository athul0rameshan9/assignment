package com.example.bookreview;

public class book {

    private String title;
    private String author;
    private String thumbnail;       // URL or local path to thumbnail image
    private String fullDescription;
    private String image;           // URL or local path to full-size image

    // Constructor
    public book(String title, String author, String thumbnail, String fullDescription, String image) {
        this.title = title;
        this.author = author;
        this.thumbnail = thumbnail;
        this.fullDescription = fullDescription;
        this.image = image;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public String getImage() {
        return image;
    }

    // Setters (optional, useful if you update values)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

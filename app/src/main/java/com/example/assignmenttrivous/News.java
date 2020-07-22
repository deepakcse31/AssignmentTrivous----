package com.example.assignmenttrivous;

public class News {
    private String name;
    private String description;
    private String title;
    private String publishedAt;
    private String imageurl;
    private String url;

    public News() {
    }

    public News(String name, String description, String title, String publishedAt, String imageurl, String url) {
        this.name = name;
        this.description = description;
        this.title = title;
        this.publishedAt = publishedAt;
        this.imageurl = imageurl;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
package com.example.prm_project_final.models;

public class CarouselItem {
    private String title;
    private String subtitle;
    private int imageResource;
    private String backgroundColor;

    public CarouselItem(String title, String subtitle, int imageResource, String backgroundColor) {
        this.title = title;
        this.subtitle = subtitle;
        this.imageResource = imageResource;
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}


package com.maroqand.assignment2.model;

public class Album {
    private String stat;
    private Photos photos;

    public Album(String responseBody) {
    }


    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}

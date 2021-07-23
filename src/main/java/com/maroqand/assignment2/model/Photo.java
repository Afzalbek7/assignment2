package com.maroqand.assignment2.model;

public class Photo {
    private String id;
    private String server;
    private String secret;
    private String title;

    public Photo(String id, String server, String secret, String title) {
        this.id = id;
        this.server = server;
        this.secret = secret;
        this.title = title;
    }

    public Photo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl(){
        return "https://live.staticflickr.com/"+server+"/"+id+"_"+secret+".jpg";
    }
}


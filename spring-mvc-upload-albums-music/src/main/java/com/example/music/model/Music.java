package com.example.music.model;


public class Music {
    private String name;
    private String singer;
    private String type;
    private String link;

    public Music() {
    }

    public Music(String name, String singer, String type, String link) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

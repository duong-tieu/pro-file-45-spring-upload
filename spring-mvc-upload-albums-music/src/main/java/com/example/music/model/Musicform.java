package com.example.music.model;

import org.springframework.web.multipart.MultipartFile;

public class Musicform {
    private String name;
    private String signer;
    private String type;
    private MultipartFile link;

    public Musicform(String name, String signer, String type, MultipartFile link) {
        this.name = name;
        this.signer = signer;
        this.type = type;
        this.link = link;
    }

    public Musicform() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }

    public Music toMusic() {
        Music music = new Music();
        music.setName(this.name);
        music.setSinger(this.signer);
        music.setType(this.type);
        music.setLink(String.valueOf(this.link));
        return music;
    }
}

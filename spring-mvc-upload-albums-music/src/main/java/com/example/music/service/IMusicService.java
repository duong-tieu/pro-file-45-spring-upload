package com.example.music.service;

import com.example.music.model.Music;
import com.example.music.model.Musicform;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void save(Music music);

}

package com.example.music.service;

import com.example.music.model.Music;
import com.example.music.model.Musicform;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService implements IMusicService{
    private static List<Music> musicList = new ArrayList<>();
    @Override
    public List<Music> findAll() {
        return musicList;
    }

    @Override
    public void save(Music music) {
        musicList.add(music);
    }
}

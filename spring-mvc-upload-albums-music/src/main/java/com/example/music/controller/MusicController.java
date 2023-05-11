package com.example.music.controller;

import com.example.music.model.Music;
import com.example.music.model.Musicform;
import com.example.music.service.IMusicService;
import com.example.music.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
public class MusicController {
    @Value("${link-music}")
    public String fileUpload;

    private final IMusicService musicService = new MusicService();

    @GetMapping("")
    public String index(Model model){
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musics", musicList);
        return "/index";
    }

    @GetMapping("/upload-song")
    public String uploadSong(Model model){
        model.addAttribute("music",new Musicform());
        return "/upload";
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute Musicform musicform) {
        MultipartFile multipartFile = musicform.getLink();
        if(!multipartFile.getContentType().equals("audio/mp3") &&
           !multipartFile.getContentType().equals("audio/wav") &&
           !multipartFile.getContentType().equals("audio/ogg") &&
           !multipartFile.getContentType().equals("audio/m4p")){
            ModelAndView modelAndView = new ModelAndView("/upload");
            modelAndView.addObject("messages","Invalid file type, please select a valid music file!");
            return modelAndView;
        }
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicform.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Music music = new Music(musicform.getName(), musicform.getName(), musicform.getType(),fileName);
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm",musicform);
        modelAndView.addObject("message", "Created new music successfully !");
        return modelAndView;
    }



}

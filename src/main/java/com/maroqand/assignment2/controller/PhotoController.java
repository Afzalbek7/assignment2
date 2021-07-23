package com.maroqand.assignment2.controller;

import com.maroqand.assignment2.service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PhotoController {
    private final PhotoService photoService;
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "search";
    }

    @PostMapping("/image")
    public String getPhoto(@RequestParam String inputText, Model model) {
        photoService.getPhotos(inputText, model);
        model.addAttribute("input", inputText);
        return "photos";
    }
}

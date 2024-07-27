package com.example.moviesfilters.controller;

import com.example.moviesfilters.dto.FilterDto;
import com.example.moviesfilters.service.GhibliApiService;
import models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
public class MainController {

    GhibliApiService ghibliApiService;

    @Autowired
    public MainController(GhibliApiService ghibliApiService) {
        this.ghibliApiService = ghibliApiService;
    }

    @GetMapping
    public String home (Model model) {
        var filterDto = new FilterDto();
        model.addAttribute("filterDto",filterDto);

        if (model.containsAttribute("filteredMovies")) {
            model.addAttribute("filteredMovies", model.asMap().get("filteredMovies"));
        } else {
            List<Movie> movies = ghibliApiService.apiCall();
            model.addAttribute("filteredMovies",movies);
        }

        return "index";
    }

}

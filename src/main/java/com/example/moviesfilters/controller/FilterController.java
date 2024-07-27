package com.example.moviesfilters.controller;

import com.example.moviesfilters.dto.FilterDto;
import com.example.moviesfilters.service.GhibliApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilterController {
    GhibliApi ghibliApi;

    @Autowired
    public FilterController(GhibliApi ghibliApi) {
        this.ghibliApi = ghibliApi;
    }

    @PostMapping("/filter")
    public String filterMovies(FilterDto filterDto, Model model) {
        return "index";
    }
}

package com.example.moviesfilters.controller;

import com.example.moviesfilters.dto.FilterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilterController {

    @PostMapping("/filter")
    public String filterMovies(FilterDto filterDto, Model model) {
        return "index";
    }
}

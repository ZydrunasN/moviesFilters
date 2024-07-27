package com.example.moviesfilters.controller;

import com.example.moviesfilters.dto.FilterDto;
import com.example.moviesfilters.service.GhibliApiService;
import com.example.moviesfilters.service.MoviesService;
import models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FilterController {
    GhibliApiService ghibliApi;
    MoviesService moviesService;

    @Autowired
    public FilterController(GhibliApiService ghibliApi, MoviesService moviesService) {
        this.ghibliApi = ghibliApi;
        this.moviesService = moviesService;
    }

    @PostMapping("/filter")
    public String filterMovies(FilterDto filterDto, RedirectAttributes redirectAttributes) {
        List<Movie> movies = ghibliApi.apiCall();
        var moviesFiltered = moviesService.filterByNameAndTime(movies,filterDto.getTitle(),filterDto.getRuntime()
                ,filterDto.getRuntimeOptions());
        redirectAttributes.addFlashAttribute("filteredMovies", moviesFiltered);

        return "redirect:";
    }
}

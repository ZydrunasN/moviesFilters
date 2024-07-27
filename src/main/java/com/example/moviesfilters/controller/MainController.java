package com.example.moviesfilters.controller;

import com.example.moviesfilters.dto.FilterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class MainController {

    @GetMapping
    public String home (Model model) {
        var filterDto = new FilterDto();
        model.addAttribute("filterDto",filterDto);
        return "index";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        if (model.containsAttribute("filteredMovies")) {
            model.addAttribute("filteredMovies", model.asMap().get("filteredMovies"));
        }
    }
}

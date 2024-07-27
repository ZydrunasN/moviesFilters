package com.example.moviesfilters.controller;

import com.example.moviesfilters.dto.FilterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String home (Model model) {
        var filterDto = new FilterDto();
        model.addAttribute("filterDto",filterDto);
        return "index";
    }
}

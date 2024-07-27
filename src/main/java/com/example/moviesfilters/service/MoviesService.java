package com.example.moviesfilters.service;

import lombok.extern.log4j.Log4j2;
import models.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
@Service
public class MoviesService {
    public List<Movie> filterByNameAndTime(List<Movie> movies, final String name, final int runtime, final String runtimeOption) {

        if(movies.isEmpty()) {
            log.warn("Empty movies List at MoviesService.filterByNameAndTime");
            return new ArrayList<>();
        }

        if((Objects.isNull(name) || name.isEmpty()) && runtime == 0){
            if(runtimeOption.equals("more")) return movies;
            if(runtimeOption.equals("less")) return new ArrayList<>();
        }


        movies = movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if(runtimeOption.equals("more")) {
            movies = movies.stream()
                    .filter(movie -> movie.getRunning_time() > runtime)
                    .collect(Collectors.toList());
        } else if(runtimeOption.equals("less")) {
            movies = movies.stream()
                    .filter(movie -> movie.getRunning_time() < runtime)
                    .collect(Collectors.toList());
        }

        return movies;
    }
}

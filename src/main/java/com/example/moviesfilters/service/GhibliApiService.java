package com.example.moviesfilters.service;

import models.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class GhibliApiService {
    private static final String URI = "https://ghibliapi.dev/films?limit=200";

    public List<Movie> apiCall() {
        WebClient client = WebClient.builder().build();
        return client.get()
                .uri(URI)
                .retrieve()
                .bodyToFlux(Movie.class)
                .collectList()
                .block();
    }
}

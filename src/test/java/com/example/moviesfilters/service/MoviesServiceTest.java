package com.example.moviesfilters.service;

import com.example.moviesfilters.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MoviesServiceTest {

    private MoviesService moviesService;
    private List<Movie> movies = new ArrayList<>();



    @BeforeEach
    public void setUp() {
        moviesService = new MoviesService();

        movies.add(Movie.builder().title("Castle in the Sky").running_time(124).build());
        movies.add(Movie.builder().title("Kaze no Tani no Naushika").running_time(10).build());
        movies.add(Movie.builder().title("Grave of the Fireflies").running_time(0).build());
        movies.add(Movie.builder().title("My Neighbor Totoro").running_time(150).build());
        movies.add(Movie.builder().title("Majo no takkyūbin").running_time(300).build());
        movies.add(Movie.builder().title("Arrietty").running_time(30).build());
    }

    @Test
    public void testFilterByName() {
        List<Movie> filteredMovies = moviesService.filterByNameAndTime(movies, "Castle", 0, "");

        assertEquals(1, filteredMovies.size());
        assertTrue(filteredMovies.stream().anyMatch(movie -> movie.getTitle().equals("Castle in the Sky")));
    }

    @Test
    public void testFilterByRuntimeMore() {
        List<Movie> filteredMovies = moviesService.filterByNameAndTime(movies, "", 100, "more");

        assertEquals(3, filteredMovies.size());
        assertTrue(filteredMovies.stream().anyMatch(movie -> movie.getTitle().equals("Castle in the Sky")));
        assertTrue(filteredMovies.stream().anyMatch(movie -> movie.getTitle().equals("My Neighbor Totoro")));
        assertTrue(filteredMovies.stream().anyMatch(movie -> movie.getTitle().equals("Majo no takkyūbin")));
    }

    @Test
    public void testFilterByRuntimeLess() {
        List<Movie> filteredMovies = moviesService.filterByNameAndTime(movies, "", 100, "less");

        assertEquals(3, filteredMovies.size());
        assertTrue(filteredMovies.stream().anyMatch(movie -> movie.getTitle().equals("Kaze no Tani no Naushika")));
        assertTrue(filteredMovies.stream().anyMatch(movie -> movie.getTitle().equals("Grave of the Fireflies")));
        assertTrue(filteredMovies.stream().anyMatch(movie -> movie.getTitle().equals("Arrietty")));
    }

    @Test
    public void testFilterByNameAndRuntimeMore() {
        List<Movie> filteredMovies = moviesService.filterByNameAndTime(movies, "Majo no takkyūbin", 150, "more");

        assertEquals(1, filteredMovies.size());
        assertTrue(filteredMovies.stream().anyMatch(movie -> movie.getTitle().equals("Majo no takkyūbin")));
    }

    @Test
    public void testFilterByNameAndRuntimeLess() {
        List<Movie> filteredMovies = moviesService.filterByNameAndTime(movies, "Arrietty", 100, "less");

        assertEquals(1, filteredMovies.size());
        assertTrue(filteredMovies.stream().anyMatch(movie -> movie.getTitle().equals("Arrietty")));
    }

    @Test
    public void testEmptyMoviesList() {
        List<Movie> movies = new ArrayList<>();
        List<Movie> filteredMovies = moviesService.filterByNameAndTime(movies, "Movie", 100, "more");

        assertTrue(filteredMovies.isEmpty());
    }

    @Test
    public void testFilterWithEmptyNameAndZeroRuntime() {
        List<Movie> filteredMovies = moviesService.filterByNameAndTime(movies, "", 0, "");

        assertEquals(6, filteredMovies.size());
    }
}
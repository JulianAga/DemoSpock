package com.glpractice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glpractice.models.Movie;
import com.glpractice.models.MovieDto;
import com.glpractice.services.MovieClient;
import com.glpractice.services.MovieService;
import com.glpractice.utils.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/movie")
public class MovieCatalogController {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MovieClient movieClient;

    @Autowired
    private MovieService movieService;


    @RequestMapping("/test/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Integer movieId) throws JsonProcessingException {
        ResponseEntity<String> movie = this.movieClient.findById(movieId, RestUtils.getApiKey());

        return mapper.readValue(movie.getBody(), Movie.class);
    }

    @PostMapping("/{movieId}")
    public ResponseEntity<?> saveMovie(@PathVariable("movieId") Integer movieId) throws JsonProcessingException {
        URI uri = RestUtils.getMovieLocation(this.movieService.saveMovie(movieId, RestUtils.getApiKey()));
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable("movieId") Integer movieId) {
        this.movieService.deleteById(movieId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> editMovie(@PathVariable("movieId") Integer movieId, MovieDto movie) throws Exception {
        return ResponseEntity.ok(this.movieService.editMovie(movieId,movie));
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable("movieId") Integer movieId) throws Exception {
        return ResponseEntity.ok(this.movieService.findById(movieId));
    }

}

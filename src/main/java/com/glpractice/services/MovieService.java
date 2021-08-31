package com.glpractice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glpractice.models.Movie;
import com.glpractice.models.MovieDto;
import com.glpractice.repository.MovieRepository;
import com.glpractice.utils.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieClient movieClient;

    @Autowired
    MovieRepository movieRepository;

    private static final ObjectMapper mapper = new ObjectMapper();

    public MovieService(MovieClient movieClient, MovieRepository movieRepository) {
        this.movieClient = movieClient;
        this.movieRepository = movieRepository;
    }

    public MovieService() {

    }

    public Movie findById(Integer id) throws Exception {
        return this.movieRepository.findById(id)
                .orElseThrow(Exception::new);
    }

    public Movie saveMovie(Integer id, String apiK) throws JsonProcessingException {
        ResponseEntity<String> movie = movieClient.findById(id, RestUtils.getApiKey());
        Movie movieToSave = mapper.readValue(movie.getBody(), Movie.class);

        return this.movieRepository.save(movieToSave);

    }

    public Movie editMovie(Integer id, MovieDto movie) throws Exception {
        Movie movieToEdit = this.findById(id);
        movieToEdit.setTitle(movie.getTitle());

        return this.movieRepository.save(movieToEdit);

    }

    public void deleteById(Integer id) {
        this.movieRepository.deleteById(id);
    }

}

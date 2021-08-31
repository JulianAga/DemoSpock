package com.glpractice.utils;

import com.glpractice.models.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class RestUtils {

    @Value(value = "${api.key}")
    private static String apiKey;

    public static URI getMovieLocation(Movie movie) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(movie.getId())
                .toUri();
    }

    public static String getApiKey() {
        return apiKey;
    }
}

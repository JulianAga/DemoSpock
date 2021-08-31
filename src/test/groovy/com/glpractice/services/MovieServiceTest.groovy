package com.glpractice.services

import com.glpractice.models.Movie
import com.glpractice.models.MovieDto
import com.glpractice.repository.MovieRepository
import spock.lang.Specification

class MovieServiceTest extends Specification{

    private MovieService movieService

    private MovieRepository movieRepository

    private MovieClient movieClient

    public void setup(){

        movieService = new MovieService(movieClient,movieRepository)

    }


    def "should save a movie in the database"() {
        given: "movie service"
        MovieService movieService = Mock()

        when: "movie controller"
        Movie response = movieService.saveMovie(21,"") >> new Movie().setTitle("hola")

        then: "return a movie response"
        response == new Movie().setTitle("hola")

    }

    def "should edit a movie from the database"() {
        given: "movie service"
        MovieService movieService = new MovieService()

        when: "movie controller"
        Movie response = movieService.editMovie(21,new MovieDto("hola")) >> new Movie().setTitle("hola")

        then: "return a movie response"
        response == new Movie().setTitle("hola")

    }





}

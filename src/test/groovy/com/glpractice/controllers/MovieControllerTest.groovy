package com.glpractice.controllers

import com.fasterxml.jackson.core.JsonProcessingException
import com.glpractice.models.Movie
import com.glpractice.models.MovieDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class MovieControllerTest extends Specification {

    MovieCatalogController movieCatalogController = new MovieCatalogController()

    def "should save a movie in the database"() {
        when: "movie controller"
        ResponseEntity<String> response = movieCatalogController.saveMovie(21)

        then: "return a 201 status code created"
        response.getStatusCode() == HttpStatus.CREATED;

    }

    def ""() {
        //setup:

        when:
        ResponseEntity<String> responseEntity = movieCatalogController.saveMovie(21);

        then:
        JsonProcessingException ex = thrown()
    }

//    def "should delete a movie of the database" (){
//        given: "movie controller"
//        MovieCatalogController movieCatalogController = new MovieCatalogController()
//
//        when: "We delete a movie"
//        movieCatalogController.editMovie()
//    }

    def "should edit a movie of the database"() {
        given: "movie controller"
        MovieCatalogController movieCatalogController = new MovieCatalogController()

        and:
        Movie movie = new Movie()

        when: "We edit a movie"
        ResponseEntity<Movie> response = movieCatalogController.editMovie(31, new MovieDto("asd"))

        then: "return the updated movie with status 200"
        response.getStatusCode() == HttpStatus.OK

    }

    def "should save a movie to the database"() {
        given: "movie controller"
        MovieCatalogController movieCatalogController = new MovieCatalogController()

        and:
        Movie movie = new Movie()

        when: "We edit a movie"
        ResponseEntity<Movie> response = movieCatalogController.saveMovie(21)

        then: "return the updated movie with status 200"
        response.getStatusCode() == HttpStatus.OK

    }

    def "should delete a movie from the database"() {

        given: "movie controller"
        MovieCatalogController movieCatalogController = new MovieCatalogController()

        when: "We delete a movie"
        movieCatalogController.deleteMovie(21)

        then:
        1 * movieCatalogController.deleteMovie(21)

    }


    def "should return a movie from the database"() {

        given: "movie controller"
        MovieCatalogController movieCatalogController = new MovieCatalogController()

        when: "We get a movie"
        ResponseEntity<Movie> movie = movieCatalogController.getMovie(21)

        then:
        movie.getStatusCode() == HttpStatus.OK;


    }



}

package com.glpractice.services

import com.glpractice.models.Movie
import spock.lang.Specification

class MovieServiceTest extends Specification{


    def "should save a movie in the database"() {
        given: "movie service"
        MovieService movieService = new MovieService()

        when: "movie controller"
        Movie response = movieService.saveMovie(21,"")

        then: "return a movie response"
        response == new Movie()

    }
}

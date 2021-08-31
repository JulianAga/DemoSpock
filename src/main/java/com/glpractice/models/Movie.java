package com.glpractice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@Data
@Entity
public class Movie {

    public Movie(){

    }

    public static class Genre {
        public int id;
        public String name;
    }

    public static class ProductionCompany {
        public int id;
        public String logo_path;
        public String name;
        public String origin_country;
    }

    public static class ProductionCountry {
        public String iso_3166_1;
        public String name;
    }

    public static class SpokenLanguage {
        public String english_name;
        public String iso_639_1;
        public String name;
    }

        public boolean adult;
        public String backdrop_path;
        public Object belongs_to_collection;
        public int budget;
        public List<Genre> genres;
        public String homepage;
        @Id
        public int id;
        public String imdb_id;
        public String original_language;
        public String original_title;
        public String overview;
        public double popularity;
        public Object poster_path;
        public List<ProductionCompany> production_companies;
        public List<ProductionCountry> production_countries;
        public String release_date;
        public int revenue;
        public int runtime;
        public List<SpokenLanguage> spoken_languages;
        public String status;
        public String tagline;
        public String title;
        public boolean video;
        public double vote_average;
        public int vote_count;



}

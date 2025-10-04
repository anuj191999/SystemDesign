package boomyshow;

import boomyshow.constant.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    private Map<City, List<Movie>> cityVsMovies;
    private static Map<String,Movie> movieVsId=new HashMap<>();
    private List<Movie> allMovies;

    public MovieController() {
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    void addMovie(Movie movie,City city){
        allMovies.add(movie);
        List<Movie> movies=cityVsMovies.getOrDefault(city,new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city,movies);
        movieVsId.put(movie.getMovieId(),movie);
    }

    List<Movie> getMoviesByCity(City city){
        return cityVsMovies.getOrDefault(city,new ArrayList<>());
    }

    public Movie getMovieById(String movieId){
        return movieVsId.getOrDefault(movieId,null);
    }

    /**
     * ALL CRUD and operation particular city
     */
}

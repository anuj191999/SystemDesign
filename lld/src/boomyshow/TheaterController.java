package boomyshow;

import boomyshow.constant.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {

    private Map<City, List<Theater>> theatersCityWise;
    List<Theater> alltheaters;

    public TheaterController() {
        this.theatersCityWise = new HashMap<>();
        alltheaters = new ArrayList<>();
    }

    void addTheater(Theater theater,City city) {
        alltheaters.add(theater);
        List<Theater> theaters = theatersCityWise.getOrDefault(city,new ArrayList<>());
        theaters.add(theater);
        theatersCityWise.put(city,theaters);
    }

    Map<String,List<Show>> getAllShow(Movie movie, City city) {
        Map<String,List<Show>> shows = new HashMap<>();
        List<Theater> theaters=theatersCityWise.get(city);

        for(Theater theater:theaters){
            List<Show> givenMovieShows=new ArrayList<>();

            List<Show> theaterShows = theater.getShows();
            for(Show show:theaterShows){
//                System.out.println(show.toString());
                if(show.getMovie().getMovieId().equals(movie.getMovieId())){
//                    System.out.println("-----"+show.getMovie().getMovieId());
                    givenMovieShows.add(show);
                }
            }

            if(!givenMovieShows.isEmpty()){
                shows.put(theater.getTheaterId(),givenMovieShows);
            }
        }
        return shows;
    }

    public void printAllShows(City city) {
        List<Theater> theaters=theatersCityWise.get(city);

        for(Theater theater:theaters){
            List<Show> theaterShows=theater.getShows();
            for(Show show:theaterShows){
                System.out.println(show.toString());
            }
        }
    }
}

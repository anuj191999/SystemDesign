package boomyshow;

import boomyshow.constant.City;
import boomyshow.constant.SeatCategories;
import boomyshow.constant.SeatStatus;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    private MovieController movieController;
    private TheaterController theaterController;

    public BookMyShow(MovieController movieController, TheaterController theaterController) {
        this.movieController = movieController;
        this.theaterController = theaterController;
    }

    public static void main(String[] args) {

        BookMyShow bookMyShow = new BookMyShow(new MovieController(), new TheaterController());
        bookMyShow.initialize();
//        bookMyShow.showMovieByCity(City.Delhi);
//        bookMyShow.showMovieByCity(City.Patna);
//        bookMyShow.showMovieByCity(City.Kanpur);
//        Map<Theater,List<Show>> shows= bookMyShow.theaterController.getAllShow(bookMyShow.movieController.getMovieById("movie-id-1"),City.Delhi);

//        for(Map.Entry<Theater,List<Show>> entry : shows.entrySet()){
//            Theater theater = entry.getKey();
//            List<Show> showList = entry.getValue();
//            System.out.println(theater.getTheaterId());
//            for(Show show : showList){
//                System.out.println(show.getMovie().getTitle());
//            }
//        }

        bookMyShow.createBooking(City.Delhi,bookMyShow.movieController.getMovieById("avengers-1"));

    }

    public void initialize(){
        initializeMovie();
        initializeTheater();
    }

    public void initializeTheater() {
        // created Seat
        Seat s1=new Seat("s1",10, SeatCategories.SILVER, SeatStatus.AVAILABLE);
        Seat s2=new Seat("s2",11, SeatCategories.GOLD, SeatStatus.AVAILABLE);

        //Creating screen;
        Screen screen1=new Screen("screen1", Arrays.asList(s1,s2));
//        Screen screen2=new Screen("screen1", Arrays.asList(s1,s2));

        // Initializing the show
        Show show1=new Show("show-1",screen1,this.movieController.getMovieById("avengers-1"),150,"10:30");
        Show show2=new Show("show-2",screen1,this.movieController.getMovieById("avengers-1"),150,"16:30");
        Show show3=new Show("show-3",screen1,this.movieController.getMovieById("dangal-1"),150,"20:30");

        Theater theater1=new Theater("PVR",Arrays.asList(screen1),Arrays.asList(show1,show2));
        Theater theater2=new Theater("PVR",Arrays.asList(screen1),Arrays.asList(show3));


        this.theaterController.addTheater(theater1,City.Delhi);
        this.theaterController.addTheater(theater2,City.Patna);

    }

    public void initializeMovie(){
        Movie avengers=new Movie("avengers-1","avengers","Action");
        Movie dangal=new Movie("dangal-1","dangal","bio");
        this.movieController.addMovie(avengers, City.Delhi);
        this.movieController.addMovie(dangal,City.Patna);

    }

    public void showMovieByCity(City city){
        List<Movie> movieList=this.movieController.getMoviesByCity(city);

        if(movieList.size()==0){
            System.out.println("No movies found");
        }

        for(Movie movie:movieList){
            System.out.println(city.toString()+" : "+movie.getTitle());
        }
    }


    public void createBooking(City userCity, Movie interestedMovie){

        Map<String,List<Show>>showTheaterWise=this.theaterController.getAllShow(interestedMovie,userCity);

        // select Theater and get select seats;
        List<Show> showList=showTheaterWise.get("PVR");

        // select seat No 11;

        // select Interested show;
        Show show=showList.get(0);

        // select seat no 11;

        if(!show.getBookedSeat().contains(11)){
            show.reserveSeat(11);
            System.out.println("Reserved seat ..... Successful");
        }

        show.reserveSeat(11);

    }
}

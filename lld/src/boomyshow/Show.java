package boomyshow;

import java.util.ArrayList;
import java.util.List;

public class Show {

    private String showId;
    private Screen screen;
    private Movie movie;
    private  int minute;
    private String startTime;
    private List<Integer> bookedSeat;

    public Show(String showId, Screen screen, Movie movie, int minute, String startTime) {
        this.showId = showId;
        this.screen = screen;
        this.movie = movie;
        this.minute = minute;
        this.startTime = startTime;
        bookedSeat=new ArrayList<>();
    }

    public String getShowId() {
        return showId;
    }

    public Screen getScreen() {
        return screen;
    }

    public int getMinute() {
        return minute;
    }

    public List<Integer> getBookedSeat() {
        return bookedSeat;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void reserveSeat(int seatId) {
        if(this.bookedSeat.contains(seatId)){
            throw new IllegalArgumentException("Seat already booked");
        }
        this.bookedSeat.add(seatId);
    }

    public String getStartTime() {
        return startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId='" + showId + '\'' +
                ", screen=" + screen +
                ", movie=" + movie +
                ", minute=" + minute +
                ", startTime='" + startTime + '\'' +
                ", bookedSeat=" + bookedSeat +
                '}';
    }
}

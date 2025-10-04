package boomyshow;

import java.util.List;

public class Theater {
    private String theaterId;
    private List<Screen> screens;
    private List<Show> shows;
    public Theater(String theaterId, List<Screen> screens, List<Show> shows) {
        this.theaterId = theaterId;
        this.screens = screens;
        this.shows = shows;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public void addScreens(Screen screen) {
        this.screens.add(screen);
    }

    public void addShows(Show show) {
        this.shows.add(show);
    }
}

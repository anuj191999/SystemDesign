package boomyshow;

import java.util.List;

public class Screen {
   private String screenId;
   private List<Seat> seats;

    public Screen(String screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
    }

    public String getScreenId() {
       return screenId;
   }
   public void setScreenId(String screenId) {
       this.screenId = screenId;
   }
   public List<Seat> getSeats() {
       return seats;
   }
   public void addSeat(Seat seat) {
       seats.add(seat);
   }
   public void removeSeat(Seat seat) {
       seats.remove(seat);
   }

    @Override
    public String toString() {
        return "Screen{" +
                "screenId='" + screenId + '\'' +
                ", seats=" + seats +
                '}';
    }
}

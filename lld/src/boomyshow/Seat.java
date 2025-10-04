package boomyshow;

import boomyshow.constant.SeatCategories;
import boomyshow.constant.SeatStatus;

import java.util.HashMap;
import java.util.Map;

public class Seat {
    private static Map<String, Seat> seats = new HashMap<>();
    private String seatId;
    private int seatNo;
    private SeatCategories categories;
    private SeatStatus status;

    public Seat(String seatId, int seatNo, SeatCategories categories,SeatStatus status) {
        this.seatId = seatId;
        this.seatNo = seatNo;
        this.categories = categories;
        this.status = status;
        seats.put(seatId, this);
    }

    public String getSeatId() {
        return seatId;
    }


    public int getseatNo() {
        return seatNo;
    }

    public SeatCategories getCategories() {
        return categories;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId='" + seatId + '\'' +
                ", seatNo=" + seatNo +
                ", categories=" + categories +
                ", status=" + status +
                '}';
    }
}

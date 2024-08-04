package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{ // Ticket class

    private List<ShowSeat> showSeats;

    private User user;

    private BookingStatus bookingStatus;

    private int amount;

    private List<Payment> payments;
}

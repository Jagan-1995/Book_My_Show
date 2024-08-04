package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    private Show show;

    private SeatType seatType;
    private int price;
}

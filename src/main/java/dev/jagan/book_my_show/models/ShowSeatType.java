package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;
    private int price;
}

/*
    1               1
 ShowSeatType ---- Show => M : 1
    M               1

    1                1
 ShowSeatType ---- SeatType => M : 1
    M                1

    A B
    AB : A => M : 1
    AB : B => M : 1
 */

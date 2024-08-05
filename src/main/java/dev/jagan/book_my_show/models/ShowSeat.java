package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

/*
     1           1
  ShowSeat ---- Show => M : 1
     M           1

     1           1
  ShowSeat ---- Seat => M : 1
     M           1


   Show     Seat     Status
    X        1         yes
    X        2          no
    X        3         yes
    X        4          no
    Y        8         yes
    Y        2          no
    Z        2         yes
 */

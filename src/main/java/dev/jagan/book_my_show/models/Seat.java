package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;

    @ManyToOne
    private SeatType seatType;
    private int rowVal; // row variable not allowed, because it is reserved keyword
    private int colVal; // col variable not allowed, because it is reserved keyword
 }

/*
   1          1
  Seat ---- SeatType => M : 1
   M          1
 */

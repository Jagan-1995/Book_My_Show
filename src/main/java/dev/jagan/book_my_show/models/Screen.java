package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
public class Screen extends BaseModel{
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
}

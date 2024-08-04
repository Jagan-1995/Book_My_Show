package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private List<Actor> actors;

}

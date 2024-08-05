package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;

    @ManyToMany
    private List<Actor> actors;

}

/*
   1          M
  Movie ---- Actor => M : M
   M          1
 */
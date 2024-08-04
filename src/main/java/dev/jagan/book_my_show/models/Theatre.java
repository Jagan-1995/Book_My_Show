package dev.jagan.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    private City city;
    private List<Screen> screens;
}


/*
 1      M
City Theatre
 1      1
 1 : M
 */
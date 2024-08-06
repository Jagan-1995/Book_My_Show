package dev.jagan.book_my_show.dtos;

import dev.jagan.book_my_show.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookMovieResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;
}

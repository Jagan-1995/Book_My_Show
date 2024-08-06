package dev.jagan.book_my_show.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookMovieRequestDto {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;
}

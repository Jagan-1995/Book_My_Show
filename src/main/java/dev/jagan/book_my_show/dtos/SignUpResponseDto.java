package dev.jagan.book_my_show.dtos;

import dev.jagan.book_my_show.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private User user;
    private ResponseStatus responseStatus;
}

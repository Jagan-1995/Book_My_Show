package dev.jagan.book_my_show.controllers;

import dev.jagan.book_my_show.dtos.ResponseStatus;
import dev.jagan.book_my_show.dtos.SignUpRequestDto;
import dev.jagan.book_my_show.dtos.SignUpResponseDto;
import dev.jagan.book_my_show.models.User;
import dev.jagan.book_my_show.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto){
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();

        try {
            User user = userService.signUp(signUpRequestDto.getName(),
                    signUpRequestDto.getEmail(),
                    signUpRequestDto.getPassword()
            );
            signUpResponseDto.setUser(user);
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception ex){
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return signUpResponseDto;
    }

}

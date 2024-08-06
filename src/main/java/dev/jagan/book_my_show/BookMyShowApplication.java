package dev.jagan.book_my_show;

import dev.jagan.book_my_show.controllers.UserController;
import dev.jagan.book_my_show.dtos.SignUpRequestDto;
import dev.jagan.book_my_show.dtos.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
        signUpRequestDto.setName("Baskar");
        signUpRequestDto.setEmail("baskar@gmail.com");
        signUpRequestDto.setPassword("abcd@1234");

        SignUpResponseDto signUpResponseDto = userController.signUp(signUpRequestDto);
    }
}

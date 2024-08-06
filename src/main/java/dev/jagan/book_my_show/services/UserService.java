package dev.jagan.book_my_show.services;

import dev.jagan.book_my_show.models.User;
import dev.jagan.book_my_show.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name,
                       String email,
                       String password){

        Optional<User> optionalUser = userRepository.findByEmail(email);

        User savedUser = null;

        if (optionalUser.isPresent()){
            throw new RuntimeException("User already exsits"); // Unchecked Exception
            // continue with login workflow

        }else {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            savedUser = userRepository.save(user);
        }
        return savedUser;
    }
}

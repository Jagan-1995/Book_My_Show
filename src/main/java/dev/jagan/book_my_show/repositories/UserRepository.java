package dev.jagan.book_my_show.repositories;

import dev.jagan.book_my_show.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);
}

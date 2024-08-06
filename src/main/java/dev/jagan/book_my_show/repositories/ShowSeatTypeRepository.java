package dev.jagan.book_my_show.repositories;

import dev.jagan.book_my_show.models.SeatType;
import dev.jagan.book_my_show.models.Show;
import dev.jagan.book_my_show.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Show show);

    Optional<ShowSeatType> findBySeatType(SeatType seatType);

}


// 100.30 => 10030
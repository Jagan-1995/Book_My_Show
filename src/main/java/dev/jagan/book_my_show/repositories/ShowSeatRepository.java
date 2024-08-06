package dev.jagan.book_my_show.repositories;

import dev.jagan.book_my_show.models.SeatType;
import dev.jagan.book_my_show.models.ShowSeat;
import dev.jagan.book_my_show.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);

    @Override
    ShowSeat save(ShowSeat showSeat);


}

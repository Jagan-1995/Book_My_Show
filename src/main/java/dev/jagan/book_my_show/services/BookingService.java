package dev.jagan.book_my_show.services;

import dev.jagan.book_my_show.exceptions.ShowNotFoundException;
import dev.jagan.book_my_show.exceptions.ShowSeatNoLongerAvailableException;
import dev.jagan.book_my_show.exceptions.UserNotFoundException;
import dev.jagan.book_my_show.models.*;
import dev.jagan.book_my_show.repositories.ShowRepository;
import dev.jagan.book_my_show.repositories.ShowSeatRepository;
import dev.jagan.book_my_show.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculatorService priceCalculatorService){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, ShowSeatNoLongerAvailableException {

        /*
        1. Get the user object with the userId.
        2. Get the show object with the showId.
        3. Get all the List of show seats with the showSeatIds.
        4. Check if all the seats are available or not.
        5. If yes, proceed with the booking.
        6. Tf no, then trow an exception.
        -----------------Take a Lock--------------
        7. Check if all the seats are available or not.
        8. Mark the Selected seat status to Blocked.
        ----------------Release the Lock-------------
        9. Create the Booking and move the payment page.
        10. If payment Succeeds :
        ----------------Take a lock ---------------
        11. Mark the Selected seat status to Booked.
        ----------------Release the Lock----------
        12. Return the booking tickets to the user.
        13. If payment Fails Or timer expires :
        ----------------Take a Lock---------------
        14. Mark the Selected seat status to Available.
        ----------------Release the lock-------------

         */

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()){
            // go to the signup workflow, ask the user to registers
            throw new UserNotFoundException("User with id "+ userId + " doesn't exist");
        }

        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isEmpty()){

            throw new ShowNotFoundException("Show with id "+ showId + " doesn't exist");
        }

        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        if (showSeats.size() == 0){
            throw new RuntimeException("Please select atleast one seat to proceed");
        }

        for (ShowSeat showSeat : showSeats){
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNoLongerAvailableException("ShowSeat with id " + showSeat.getId() + " isn't available");
            }
        }

        for (ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            // change the status in DB as well
            showSeatRepository.save(showSeat);
        }

        // Create the booking and Move to the payment page.

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setCreatedAt(new Date());
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, show));

        // Move to the payment page
        /*
         Save the booking in the DB
         if booking succeeds => make the seats are permanently booked
         if booking fails => make the seats available back
         */

        return booking;


    }
}

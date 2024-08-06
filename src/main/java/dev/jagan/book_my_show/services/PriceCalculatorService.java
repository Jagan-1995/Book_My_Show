package dev.jagan.book_my_show.services;

import dev.jagan.book_my_show.models.SeatType;
import dev.jagan.book_my_show.models.Show;
import dev.jagan.book_my_show.models.ShowSeat;
import dev.jagan.book_my_show.models.ShowSeatType;
import dev.jagan.book_my_show.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceCalculatorService {

    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeats, Show show){
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        /*
        Show SeatType price
        1       1      100
        1       2      200
        1       3      300
        1       4      250
        1       5       60
        1       6       500

         */
        int totalAmount = 0;

        for (ShowSeat showSeat : showSeats){
            /*
            price of the current show seat
             */
             SeatType seatType = showSeat.getSeat().getSeatType(); // another method

//            Optional<ShowSeatType> showSeat1 = showSeatTypeRepository.findBySeatType(seatType); // another method
//            show, seatType, price // another method
//            totalAmount += showSeat1.get().getPrice(); // another method


            for (ShowSeatType showSeatType : showSeatTypes){
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    totalAmount += showSeatType.getPrice();
                    break;
                }
            }
        }

        return totalAmount;

    }
}


/*
List<ShowSeats>
1. show-id,  seat-id,  status
2.
3.
4.
 */
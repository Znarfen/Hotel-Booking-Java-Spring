package com.example.Hotel_Booking_Java_Spring;

import java.util.List;
import org.springframework.web.bind.annotation.*;

// Route

@RestController
@RequestMapping("/booking")
public class BookingRoute {

    private final BookingRep repo;

    public BookingRoute(BookingRep repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Booking> getBookings() {return repo.findAll();}

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) throws BookingErr {
        if (booking.getNumberOfGuests() <= 0) {
            throw new BookingErr("Number of guests must be greater than zero.");
        }
        return repo.save(booking);
    }
}
package com.example.Hotel_Booking_Java_Spring;

import java.security.Principal;
import java.util.List;
import org.springframework.web.bind.annotation.*;

// Route

@RestController
@RequestMapping("/booking")
public class BookingRoute {

    private final BookingRep bookingRepo;
    private final BookingService bookingService;

    public BookingRoute(BookingRep bookingRepo, BookingService bookingService) {
        this.bookingRepo = bookingRepo;
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getBookings() {return bookingRepo.findAll();}

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking, Principal principal ) throws BookingErr {

        bookingService.bookRoom(booking, principal.getName());

        return booking;
    }
}
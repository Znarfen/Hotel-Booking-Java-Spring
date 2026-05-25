package com.example.Hotel_Booking_Java_Spring;

import java.security.Principal;
import java.util.List;
import org.springframework.web.bind.annotation.*;

// Route

@RestController
@RequestMapping("/booking")
public class BookingRoute {

    private final BookingRep bookingRepo;
    private final RoomRep roomRepo;
    private boolean booked = false;

    public BookingRoute(BookingRep bookingRepo, RoomRep roomRepo) {
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
    }

    @GetMapping
    public List<Booking> getBookings() {return bookingRepo.findAll();}

    @GetMapping("/rooms")
    public List<Room> getRooms() {return roomRepo.findAll();}

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking, Principal principal ) throws BookingErr {

        booking.setName(principal.getName());

        new BookingService(bookingRepo, roomRepo).BookRoom(booking);

        return bookingRepo.save(booking);
    }
}
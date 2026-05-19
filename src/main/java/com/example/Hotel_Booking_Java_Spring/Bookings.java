package com.example.Hotel_Booking_Java_Spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bookings {

    @GetMapping("/bookings")
    public String getBookings() {
        return "List of bookings";
    }

    @PostMapping("/bookings")
    public String createBooking() {
        return "Create a new booking";
    }
}
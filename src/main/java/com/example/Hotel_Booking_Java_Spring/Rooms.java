package com.example.Hotel_Booking_Java_Spring;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rooms {
    
    private final RoomRep repo;
    public Rooms(RoomRep repo) {
        this.repo = repo;
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return repo.findAll();
    }
}
package com.example.Hotel_Booking_Java_Spring;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roomId;
    private int numberOfGuests;
    private String guestName;

    public Booking() {}

    public Booking(int roomId, int numberOfGuests, String guestName) {
        this.roomId = roomId;
        this.numberOfGuests = numberOfGuests;
        this.guestName = guestName;
    }

    public int getId() {return id;}
    public int getRoomId() {return roomId;}
    public int getNumberOfGuests() {return numberOfGuests;}
    public String getGuestName() {return guestName;}
}

interface BookingRep extends JpaRepository<Booking, Long> {}
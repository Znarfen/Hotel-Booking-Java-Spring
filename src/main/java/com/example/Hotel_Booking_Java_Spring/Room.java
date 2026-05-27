package com.example.Hotel_Booking_Java_Spring;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;

    @Min(value = 1, message = "Cost must be greater than 0")
    private int cost;
    
    @NotBlank(message = "Room type cannot be empty")
    private String type;

    @Min(value = 1, message = "Capacity must be greater than 0")
    private int capacity;

    private boolean occupied = false;

    private String guestName;

    public Room() {}

    public Room(String type, int cost) {
        this.type = type;
        this.cost = cost;

        if (this.type.equals("Single")) this.capacity = 1;
        else if (this.type.equals("Double")) this.capacity = 2;
        else if (this.type.equals("Suite")) this.capacity = 4;
    }

    public int getId() {return id;}
    public String getType() {return type;}
    public int getCapacity() {return capacity;}
    public int getCost() {return cost;}
    public boolean isOccupied() {return occupied;}
    public String getGuestName() {return guestName;}

    public void setId(int id) {this.id = id;}
    public void setType(String type) {this.type = type;}
    public void setOccupation(boolean occupied) {this.occupied = occupied;}
    public void setGuestName(String guestName) {this.guestName = guestName;}
}

interface RoomRep extends JpaRepository<Room, Long> {}
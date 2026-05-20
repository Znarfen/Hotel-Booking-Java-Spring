package com.example.Hotel_Booking_Java_Spring;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String type;
    private double price;
    private int capacity;
    private boolean occupied = false;

    public Room() {}

    public Room(String type, double price) {
        this.type = type;
        this.price = price;

        if (this.type.equals("Single")) this.capacity = 1;
        else if (this.type.equals("Double")) this.capacity = 2;
        else if (this.type.equals("Suite")) this.capacity = 4;
    }

    public int getId() {return id;}

    public String getType() {return type;}

    public double getPrice() {return price;}

    public int getCapacity() {return capacity;}

    public boolean isOccupied() {return occupied;}

    public void setId(int id) {this.id = id;}

    public void setType(String type) {this.type = type;}

    public void setPrice(double price) {this.price = price;}

    public void setOccupation(boolean occupied) {this.occupied = occupied;}
}

interface RoomRep extends JpaRepository<Room, Long> {}
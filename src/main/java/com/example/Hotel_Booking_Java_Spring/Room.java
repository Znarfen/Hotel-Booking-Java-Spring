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

    public Room() {}

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public int getId() {return id;}

    public String getType() {return type;}

    public double getPrice() {return price;}

    public void setId(int id) {this.id = id;}

    public void setType(String type) {this.type = type;}

    public void setPrice(double price) {this.price = price;}
}

interface RoomRep extends JpaRepository<Room, Long> {}
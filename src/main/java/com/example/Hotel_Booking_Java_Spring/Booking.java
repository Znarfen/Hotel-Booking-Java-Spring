package com.example.Hotel_Booking_Java_Spring;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Pattern(regexp = "^(Single|Double|Suite)$", message = "Room type must be either 'Single', 'Double', or 'Suite'")
    private String roomType;

    @Min(value = 1, message = "At least 1 guest required")
    private int numberOfGuests;

    @Positive(message = "Price must be greater than 0")
    private int totalPrice;

    @NotBlank(message = "Guest name cannot be empty")
    private String guestName;

    @Positive(message = "Room ID must be greater than 0")
    private int roomId;

    //private String msg;

    public Booking() {}

    public Booking(String roomType, int numberOfGuests, String guestName) {
        this.roomType = roomType;
        this.numberOfGuests = numberOfGuests;
        this.guestName = guestName;
    }

    public void setName(String name) {this.guestName = name;}
    public void setTotalPrice(int totalPrice) {this.totalPrice = totalPrice;}
    public void setRoomType(String roomType) {this.roomType = roomType;}
    public void setRoomId(int roomId) {this.roomId = roomId;}
    //public void setMsg(String msg) {this.msg = msg;}

    public int getId() {return id;}
    public String getRoomType() {return roomType;}
    public int getNumberOfGuests() {return numberOfGuests;}
    public String getGuestName() {return guestName;}
    public int getTotalPrice() {return totalPrice;}
    public int getRoomId() {return roomId;}
    //public String getMsg() {return msg;}
}

interface BookingRep extends JpaRepository<Booking, Long> {}
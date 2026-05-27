package com.example.Hotel_Booking_Java_Spring;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    private final BookingRep bookingRepo;
    private final RoomRep roomRepo;

    public BookingService(
            BookingRep bookingRepo,
            RoomRep roomRepo) {

        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
    }

    private List<Room> sortRoomsByCost() {
        List<Room> rooms = roomRepo.findAll();
        rooms.sort((r1, r2) -> Integer.compare(r1.getCost(), r2.getCost()));
        return rooms;
    }
    
    public void bookRoom(Booking booking, String bookedBy) throws BookingErr {
        List<Room> rooms = sortRoomsByCost();

        if (booking.getNumberOfGuests() <= 0) {
            throw new BookingErr("Number of guests must be greater than zero.");
        }

        for (Room room : rooms) {
            if (!room.isOccupied() && room.getCapacity() >= booking.getNumberOfGuests()) {
                room.setOccupation(true);
                room.setGuestName(bookedBy);
                roomRepo.save(room);

                booking.setName(bookedBy);
                booking.setTotalPrice(room.getCost());
                booking.setRoomType(room.getType());
                booking.setRoomId(room.getId());
                bookingRepo.save(booking);
                return;
            }
        }
        throw new BookingErr("No available rooms for the specified number of guests.");
    }
}

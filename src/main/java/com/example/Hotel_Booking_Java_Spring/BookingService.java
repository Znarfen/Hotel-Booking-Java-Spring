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
    
    public void BookRoom(Booking booking) throws BookingErr {
        List<Room> rooms = roomRepo.findAll();

        if (booking.getNumberOfGuests() <= 0) {
            throw new BookingErr("Number of guests must be greater than zero.");
        }

        for (Room room : rooms) {
            if (!room.isOccupied() && room.getCapacity() >= booking.getNumberOfGuests()) {
                room.setOccupation(true);
                room.setGuestName(booking.getGuestName());
                roomRepo.save(room);

                booking.setTotalPrice(room.getCost());
                booking.setRoomType(room.getType());
                booking.setRoomId(room.getId());
                return;
            }
        }
        throw new BookingErr("No available rooms for the specified number of guests.");
    }
}

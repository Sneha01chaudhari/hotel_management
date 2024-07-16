import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private List<Room> bookedRooms;

    public Reservation() {
        bookedRooms = new ArrayList<>();
    }

    public boolean bookRoom(Hotel hotel, int roomNumber) {
        Room room = hotel.getRoomByNumber(roomNumber);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            bookedRooms.add(room);
            System.out.println("Room booked successfully: " + room);
            return true;
        } else {
            System.out.println("Room not available or doesn't exist.");
            return false;
        }
    }

    public void viewBookings() {
        if (bookedRooms.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            System.out.println("Booked Rooms:");
            for (Room room : bookedRooms) {
                System.out.println(room);
            }
        }
    }
}

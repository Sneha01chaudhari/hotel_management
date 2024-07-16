import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Reservation reservation = new Reservation();
        Payment payment = new Payment();

        // Adding some rooms to the hotel
        hotel.addRoom(new Room(101, "Single", 100.0));
        hotel.addRoom(new Room(102, "Double", 150.0));
        hotel.addRoom(new Room(103, "Suite", 300.0));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room category (Single/Double/Suite): ");
                    String category = scanner.next();
                    System.out.println("Available rooms:");
                    for (Room room : hotel.searchAvailableRooms(category)) {
                        System.out.println(room);
                    }
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    if (reservation.bookRoom(hotel, roomNumber)) {
                        Room bookedRoom = hotel.getRoomByNumber(roomNumber);
                        payment.processPayment(bookedRoom.getPrice());
                    }
                    break;

                case 3:
                    reservation.viewBookings();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

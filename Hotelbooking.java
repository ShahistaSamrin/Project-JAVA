import java.util.*;

class HotelBooking{
    private String guestName;
    private String checkInDate;
    private String checkOutDate;
    public Hotelbooking(String guestName, String checkInDate, String checkOutDate) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    public String getGuestName() {
        return guestName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }
    public String toString() {
        return "Guest: " + guestName + ", Check-in: " + checkInDate + ", Check-out: " + checkOutDate;
    }
}

public class HotelBookingSystem {
    private static Map<Integer, Booking> rooms = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (int i = 1; i <= 5; i++) {
            if (!rooms.containsKey(i)) {
                System.out.println("Room " + i + " - Available");
            }
        }
    }
    public static void bookRoom() {
        System.out.print("Enter Room Number (1-5): ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();  

        if (rooms.containsKey(roomNumber)) {
            System.out.println("Sorry, Room " + roomNumber + " is already booked.");
        } else {
            System.out.print("Enter Guest Name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter Check-in Date (YYYY-MM-DD): ");
            String checkInDate = scanner.nextLine();

            System.out.print("Enter Check-out Date (YYYY-MM-DD): ");
            String checkOutDate = scanner.nextLine();

            Booking booking = new Booking(guestName, checkInDate, checkOutDate);
            rooms.put(roomNumber, booking);
            System.out.println("Room " + roomNumber + " booked successfully for " + guestName);
        }
    }
    public static void viewBookings() {
        System.out.println("\nCurrent Bookings:");
        if (rooms.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Map.Entry<Integer, Booking> entry : rooms.entrySet()) {
                System.out.println("Room " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    public static void cancelBooking() {
        System.out.print("Enter Room Number to cancel booking (1-5): ");
        int roomNumber = scanner.nextInt();

        if (rooms.containsKey(roomNumber)) {
            rooms.remove(roomNumber);
            System.out.println("Room " + roomNumber + " booking cancelled.");
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }
    public static void showMenu() {
        System.out.println("\n--- Hotel Booking System ---");
        System.out.println("1. Show Available Rooms");
        System.out.println("2. Book a Room");
        System.out.println("3. View All Bookings");
        System.out.println("4. Cancel a Booking");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAvailableRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}

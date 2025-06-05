package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.utils.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserBookingService {

    private User user;
    private List<User> userList;
    private final ObjectMapper objectMapper;
    private static final String USERS_PATH = "app/src/main/java/ticket/booking/localDb/users.json";

    public UserBookingService() throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        loadUsers();
    }

    private void loadUsers() throws IOException {
        userList = objectMapper.readValue(new File(USERS_PATH), new TypeReference<List<User>>() {});
        System.out.println("👥 User database loaded. Total users: " + userList.size());
    }

    public boolean signUp(User newUser) {
        try {
            Optional<User> existing = userList.stream()
                    .filter(user -> user.getUsername().equalsIgnoreCase(newUser.getUsername()))
                    .findFirst();

            if (existing.isPresent()) {
                System.out.println("❗ Username already taken. Please try another one.");
                return false;
            }

            userList.add(newUser);
            saveUserListToFile();
            System.out.println("✅ Signup successful! Welcome, " + newUser.getUsername() + " 🎉");
            return true;

        } catch (Exception ex) {
            System.out.println("❌ Failed to register user: " + ex.getMessage());
            return false;
        }
    }

    private void saveUserListToFile() {
        try {
            objectMapper.writeValue(new File(USERS_PATH), userList);
            System.out.println("💾 User data saved successfully.");
        } catch (IOException e) {
            System.out.println("❌ Failed to save user data: " + e.getMessage());
        }
    }

    public void fetchBookings() {
        if (user == null) {
            System.out.println("⚠️ No user session active. Please log in.");
            return;
        }

        System.out.println("📄 Fetching bookings for: " + user.getUsername());
        user.printTickets();
    }

    public Optional<User> getUserByUsername(String username) {
        return userList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public void setUser(User currentUser) {
        this.user = currentUser;
        System.out.println("🔑 Logged in as: " + currentUser.getUsername());
    }

    public boolean cancelBooking(String ticketId) {
        if (user == null) {
            System.out.println("⚠️ Please log in to cancel a booking.");
            return false;
        }

        if (ticketId == null || ticketId.trim().isEmpty()) {
            System.out.println("❗ Ticket ID cannot be empty.");
            return false;
        }

        boolean removed = user.getTicketsBooked()
                .removeIf(ticket -> ticket.getTicketId().equals(ticketId));

        if (removed) {
            saveUserListToFile();
            System.out.println("❌ Booking cancelled successfully for Ticket ID: " + ticketId);
            return true;
        } else {
            System.out.println("🚫 No ticket found with ID: " + ticketId);
            return false;
        }
    }

    public List<Train> getTrains(String source, String destination) {
        try {
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source, destination);
        } catch (Exception ex) {
            System.out.println("⚠️ Error fetching trains: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    public List<List<Integer>> fetchSeats(Train train) {
        return train.getSeats();
    }

    public boolean bookTrainSeat(Train train, int row, int seat) {
        if (user == null) {
            System.out.println("⚠️ Please log in to book a ticket.");
            return false;
        }

        try {
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeats();

            if (row < 0 || row >= seats.size() || seat < 0 || seat >= seats.get(row).size()) {
                System.out.println("🚫 Invalid seat selection.");
                return false;
            }

            if (seats.get(row).get(seat) == 1) {
                System.out.println("⛔ Seat already booked. Choose another.");
                return false;
            }

            // Book the seat
            seats.get(row).set(seat, 1);
            train.setSeats(seats);
            trainService.addTrain(train);

            // Create and assign ticket
            Ticket ticket = new Ticket();
            ticket.setSource(train.getStations().getFirst());
            ticket.setDestination(train.getStations().getLast());
            ticket.setTrain(train);
            ticket.setUserId(user.getUserId());
            ticket.setDateOfTravel("2021-09-01");
            ticket.setTicketId(UserServiceUtil.generateTicketId());

            user.getTicketsBooked().add(ticket);
            saveUserListToFile();

            System.out.println("🎟️ Seat booked successfully!");
            System.out.println(ticket.getTicketInfo());

            return true;

        } catch (IOException ex) {
            System.out.println("❗ Booking failed: " + ex.getMessage());
            return false;
        }
    }
}

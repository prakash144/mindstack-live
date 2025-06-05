package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ticket.booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainService {

    private List<Train> trainList;
    private final ObjectMapper objectMapper;
    private static final String TRAIN_DB_PATH = "app/src/main/java/ticket/booking/localDb/trains.json";

    public TrainService() throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        loadTrains();
    }

    private void loadTrains() throws IOException {
        trainList = objectMapper.readValue(new File(TRAIN_DB_PATH), new TypeReference<List<Train>>() {});
        System.out.println("📥 Train data loaded successfully! Total trains: " + trainList.size());
    }

    public List<Train> searchTrains(String source, String destination) {
        System.out.println("🔍 Searching trains from " + source + " to " + destination + "...");
        try {
            List<Train> results = trainList.stream()
                    .filter(train -> isValidTrain(train, source, destination))
                    .collect(Collectors.toList());

            if (results.isEmpty()) {
                System.out.println("⚠️ No trains found for the selected route.");
            } else {
                System.out.println("✅ Found " + results.size() + " train(s) matching the route.");
            }

            return results;
        } catch (Exception ex) {
            System.out.println("❌ Error while searching trains: " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    public void addTrain(Train newTrain) {
        Optional<Train> existingTrain = trainList.stream()
                .filter(train -> train.getTrainId().equalsIgnoreCase(newTrain.getTrainId()))
                .findFirst();

        if (existingTrain.isPresent()) {
            System.out.println("✏️ Updating existing train: " + newTrain.getTrainId());
            updateTrain(newTrain);
        } else {
            System.out.println("➕ Adding new train: " + newTrain.getTrainId());
            trainList.add(newTrain);
            saveTrainListToFile();
        }
    }

    public void updateTrain(Train updatedTrain) {
        OptionalInt index = IntStream.range(0, trainList.size())
                .filter(i -> trainList.get(i).getTrainId().equalsIgnoreCase(updatedTrain.getTrainId()))
                .findFirst();

        if (index.isPresent()) {
            trainList.set(index.getAsInt(), updatedTrain);
            saveTrainListToFile();
            System.out.println("💾 Train updated successfully!");
        } else {
            System.out.println("🔄 Train not found. Adding as new.");
            addTrain(updatedTrain);
        }
    }

    public boolean bookTickets(Train train, int row, int seat) {
        List<List<Integer>> seats = train.getSeats();
        try {
            if (row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()) {
                if (seats.get(row).get(seat) == 0) {
                    seats.get(row).set(seat, 1);
                    train.setSeats(seats);
                    addTrain(train);
                    System.out.println("🎟️ Ticket booked successfully! [Row: " + row + ", Seat: " + seat + "]");
                    return true;
                } else {
                    System.out.println("⛔ Seat already booked! Try a different seat.");
                }
            } else {
                System.out.println("❌ Invalid seat selection.");
            }
        } catch (Exception e) {
            System.out.println("❗ Error during booking: " + e.getMessage());
        }
        return false;
    }

    private boolean isValidTrain(Train train, String source, String destination) {
        List<String> stations = train.getStations();
        int sourceIndex = stations.indexOf(source);
        int destinationIndex = stations.indexOf(destination);

        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }

    private void saveTrainListToFile() {
        try {
            objectMapper.writeValue(new File(TRAIN_DB_PATH), trainList);
            System.out.println("💾 Train list saved to local DB.");
        } catch (IOException e) {
            System.out.println("❌ Failed to save train list: " + e.getMessage());
        }
    }
}
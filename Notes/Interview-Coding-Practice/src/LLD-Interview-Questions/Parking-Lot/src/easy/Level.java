package easy;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int levelNumber;
    private List<ParkingSpot> spots;

    public Level(int levelNumber, int numberOfSpots) {
        this.levelNumber = levelNumber;
        spots = new ArrayList<>(numberOfSpots);
        for (int i = 0; i < numberOfSpots; i++) {
            spots.add(new ParkingSpot(i % 2 == 0 ? VehicleType.CAR : VehicleType.BIKE)); // Alternate types for example
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.park(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.getCurrentVehicle() == vehicle) {
                spot.unpark();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("easy.Level " + levelNumber + ":\n");
        for (ParkingSpot spot : spots) {
            sb.append(spot.toString()).append("\n");
        }
        return sb.toString();
    }
}

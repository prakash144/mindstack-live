package easy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> levels;

    private ParkingLot(int numberOfLevels, int spotsPerLevel) {
        levels = new ArrayList<>(numberOfLevels);
        for (int i = 0; i < numberOfLevels; i++) {
            levels.add(new Level(i, spotsPerLevel));
        }
    }

    public static synchronized ParkingLot getInstance(int numberOfLevels, int spotsPerLevel) {
        if (instance == null) {
            instance = new ParkingLot(numberOfLevels, spotsPerLevel);
        }
        return instance;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void printStatus() {
        System.out.println("Parking Lot Status:");
        for (Level level : levels) {
            System.out.println(level);
        }
    }
}

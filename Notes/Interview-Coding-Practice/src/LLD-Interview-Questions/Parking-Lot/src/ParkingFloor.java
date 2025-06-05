import java.util.ArrayList;
import java.util.List;

class ParkingFloor {
    public String floorName;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(String floorName) {
        this.floorName = floorName;
        this.parkingSpots = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
        System.out.println("Added spot " + spot.getNumber() + " of type " + spot.getType() + " to " + floorName);
    }

    public boolean isFull() {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isFree()) {
                return false;
            }
        }
        return true;
    }

    public ParkingSpot getAvailableSpot(ParkingSpotType type) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isFree() && spot.getType() == type) {
                return spot;
            }
        }
        return null;
    }

    public void displayFloorStatus() {
        System.out.println("Status of " + floorName + ":");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getNumber() + " (" + spot.getType() + ") - " + (spot.isFree() ? "Free" : "Occupied"));
        }
    }
}

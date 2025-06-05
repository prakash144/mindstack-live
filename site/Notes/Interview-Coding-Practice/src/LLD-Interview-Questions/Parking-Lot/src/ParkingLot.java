import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private static ParkingLot instance;
    private String name;
    private Address address;
    private List<ParkingFloor> parkingFloors;

    private ParkingLot(String name, Address address) {
        this.name = name;
        this.address = address;
        this.parkingFloors = new ArrayList<>();
    }

    public static ParkingLot getInstance(String name, Address address) {
        if (instance == null) {
            instance = new ParkingLot(name, address);
        }
        return instance;
    }

    public void addParkingFloor(ParkingFloor floor) {
        parkingFloors.add(floor);
        System.out.println("Added floor: " + floor.floorName);
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        ParkingSpotType spotType = getSpotTypeForVehicle(vehicleType);
        for (ParkingFloor floor : parkingFloors) {
            ParkingSpot spot = floor.getAvailableSpot(spotType);
            if (spot != null) {
                return spot;
            }
        }
        return null;
    }

    private ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return ParkingSpotType.COMPACT;
            case TRUCK:
                return ParkingSpotType.LARGE;
            case MOTORCYCLE:
                return ParkingSpotType.MOTORCYCLE;
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }

    public void displayLotStatus() {
        System.out.println("Parking Lot: " + name);
        System.out.println("Address: " + address);
        for (ParkingFloor floor : parkingFloors) {
            floor.displayFloorStatus();
        }
    }
}
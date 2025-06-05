package easy;

public class ParkingSpot {
    private final VehicleType spotType;
    private Vehicle currentVehicle;

    public ParkingSpot(VehicleType spotType) {
        this.spotType = spotType;
    }

    public boolean isAvailable() {
        return currentVehicle == null;
    }

    public boolean park(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleType() == spotType) {
            currentVehicle = vehicle;
            return true;
        }
        return false;
    }

    public void unpark() {
        currentVehicle = null;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    @Override
    public String toString() {
        return "easy.educativeIO.ParkingSpot{" +
                "Type=" + spotType +
                ", Occupied=" + (currentVehicle != null) +
                ", easy.educativeIO.Vehicle=" + (currentVehicle != null ? currentVehicle.getLicensePlate() : "None") +
                '}';
    }
}

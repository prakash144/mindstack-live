public class Main {
    public static void main(String[] args) {
        Address address = new Address("123 Main St", "City", "State", "12345", "Country");
        ParkingLot parkingLot = ParkingLot.getInstance("City Parking", address);

        ParkingFloor floor1 = new ParkingFloor("Ground Floor");
        floor1.addParkingSpot(new ParkingSpot("G1", ParkingSpotType.COMPACT));
        floor1.addParkingSpot(new ParkingSpot("G2", ParkingSpotType.LARGE));
        floor1.addParkingSpot(new ParkingSpot("G3", ParkingSpotType.MOTORCYCLE));

        parkingLot.addParkingFloor(floor1);

        parkingLot.displayLotStatus();

        Vehicle car = new Vehicle("CAR123", VehicleType.CAR);
        System.out.println("Looking for a spot for vehicle: " + car.getLicenseNumber());

        ParkingSpot spot = parkingLot.findAvailableSpot(car.getType());

        if (spot != null) {
            System.out.println("Spot allocated: " + spot.getNumber());
            spot.occupySpot();
        } else {
            System.out.println("No available spot for the vehicle.");
        }

        parkingLot.displayLotStatus();
    }
}
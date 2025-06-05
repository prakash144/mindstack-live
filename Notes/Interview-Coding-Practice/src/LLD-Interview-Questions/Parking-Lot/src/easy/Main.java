package easy;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance(3, 5); // 3 levels, each with 10 spots

        Vehicle car1 = new Car("CAR123");
        Vehicle motorcycle1 = new Bike("MOTO456");

        // Park vehicles
        if (parkingLot.parkVehicle(car1)) {
            System.out.println("easy.educativeIO.Car parked.");
        } else {
            System.out.println("No spot available for car.");
        }
        parkingLot.printStatus();  // Print after parking car

        if (parkingLot.parkVehicle(motorcycle1)) {
            System.out.println("easy.Bike parked.");
        } else {
            System.out.println("No spot available for motorcycle.");
        }
        parkingLot.printStatus();  // Print after parking motorcycle

        // Unpark vehicles
        if (parkingLot.unparkVehicle(car1)) {
            System.out.println("easy.educativeIO.Car unparked.");
        } else {
            System.out.println("easy.educativeIO.Car not found.");
        }
        parkingLot.printStatus();  // Print after unparking car
    }
}

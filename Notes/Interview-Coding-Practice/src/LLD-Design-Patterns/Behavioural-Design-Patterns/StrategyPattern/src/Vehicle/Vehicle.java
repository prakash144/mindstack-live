package Vehicle;

import Strategy.DriveStrategy;

/**
 * Represents a generic vehicle with a drive strategy.
 * Uses strategy pattern for driving behavior.
 */
public class Vehicle {
    private DriveStrategy driveStrategy;

    // Constructor Injection for drive strategy
    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    // Executes the drive strategy
    public void drive() {
        driveStrategy.drive();
    }
}

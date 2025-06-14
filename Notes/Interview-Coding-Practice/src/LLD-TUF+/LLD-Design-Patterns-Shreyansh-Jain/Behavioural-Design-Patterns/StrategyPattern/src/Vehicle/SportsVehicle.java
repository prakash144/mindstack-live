package Vehicle;

import Strategy.SportsDriveStrategy;

/**
 * Represents a sports vehicle with a high-performance drive strategy.
 */
public class SportsVehicle extends Vehicle {

    // Constructor initializes the sports driving strategy
    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}

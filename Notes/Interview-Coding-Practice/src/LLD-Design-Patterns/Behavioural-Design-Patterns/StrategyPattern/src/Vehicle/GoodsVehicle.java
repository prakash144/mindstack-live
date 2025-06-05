package Vehicle;

import Strategy.NormalDriveStrategy;

/**
 * Represents a goods vehicle with a normal drive strategy.
 */
public class GoodsVehicle extends Vehicle {

    // Constructor initializes the normal driving strategy
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
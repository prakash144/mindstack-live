import Vehicle.*;

/**
 * Flowchart / Mind-Map:
 * <p>
 *                       +-------------------------------------------+
 *                       |                  Vehicle                  |
 *                       +-------------------------------------------+
 *                               |
 *                               | (uses DriveStrategy)
 *                               v
 *     +---------------------------+          +---------------------------+
 *     |       SportsVehicle        |          |        GoodsVehicle       |
 *     +---------------------------+          +---------------------------+
 *               |                                   |
 *    +---------------------------+          +---------------------------+
 *    |   SportsDriveStrategy      |          |   NormalDriveStrategy     |
 *    +---------------------------+          +---------------------------+
 * <p>
 * Main class demonstrates the strategy pattern in action.
 */
public class Main {
    public static void main(String[] args) {
        // Create a SportsVehicle and execute its drive strategy
        Vehicle sportsCar = new SportsVehicle();
        sportsCar.drive(); // Output: Sports Drive capability

        // Create a GoodsVehicle and execute its drive strategy
        Vehicle goodsTruck = new GoodsVehicle();
        goodsTruck.drive(); // Output: Normal Drive capability
    }
}

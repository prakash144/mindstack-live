package Strategy;

/**
 * Implements the sports driving strategy for high-performance vehicles.
 */
public class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Sports Drive capability");
    }
}

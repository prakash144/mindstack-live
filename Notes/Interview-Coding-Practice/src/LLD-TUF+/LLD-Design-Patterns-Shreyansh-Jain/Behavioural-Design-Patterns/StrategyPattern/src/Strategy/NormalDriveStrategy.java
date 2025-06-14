package Strategy;

/**
 * Implements the normal driving strategy for standard vehicles.
 */
public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal Drive capability");
    }
}

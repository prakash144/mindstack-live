/**
 * This class demonstrates the Liskov Substitution Principle (LSP).
 * LSP states that objects of a derived class should be able to replace objects of the base class
 * without affecting the program's correctness. Derived classes should enhance, not restrict, the behavior.
 * <p>
 * FLOWCHART:
 * <p>
 *       +-------------------+
 *       |     Vehicle        |   <- Base class with common behavior
 *       +-------------------+
 *       | + getNumberOfWheels() |
 *       +-------------------+
 *              /       \
 *     +--------------------+         +-------------------+
 *     |   EngineVehicle     |         |     Bicycle       |
 *     +--------------------+         +-------------------+
 *     | + getNumberOfWheels()|         | + getNumberOfWheels() |
 *     | + hasEngine()        |         | (inherits Vehicle)  |
 *     +--------------------+         +-------------------+
 *          /         \
 * +----------------+ +----------------+
 * |      Car        | |   MotorCycle   |
 * +----------------+ +----------------+
 * | inherits Engine | | inherits Engine|
 * +----------------+ +----------------+
 * <p>
 * - `Vehicle` provides a general structure, ensuring the number of wheels.
 * - `EngineVehicle` adds more functionality (hasEngine) without narrowing the base functionality.
 * - Both `Car` and `MotorCycle` extend `EngineVehicle`, adding no restrictions.
 * - `Bicycle` extends `Vehicle` but does not have an engine, respecting the substitution.
 */

public class L_iskovSubstitution {

    // Base class: Represents any general vehicle
    public class Vehicle {
        public Integer getNumberOfWheels() {
            return 2; // Default number of wheels (e.g., for a bicycle)
        }
    }

    // EngineVehicle class extends Vehicle but adds an engine capability
    public class EngineVehicle extends Vehicle {
        @Override
        public Integer getNumberOfWheels() {
            return 4; // Default for engine vehicles (e.g., car, motorcycle)
        }

        // Additional behavior for vehicles with engines
        public boolean hasEngine() {
            return true;
        }
    }

    // Bicycle inherits Vehicle, does not narrow down functionality
    public class Bicycle extends Vehicle {
        @Override
        public Integer getNumberOfWheels() {
            return 2; // Specific to bicycles
        }
    }

    // Car extends EngineVehicle, inherits both wheel count and engine behavior
    public class Car extends EngineVehicle {
        // Inherits hasEngine and getNumberOfWheels from EngineVehicle
    }

    // Motorcycle extends EngineVehicle, inherits both wheel count and engine behavior
    public class MotorCycle extends EngineVehicle {
        // Inherits hasEngine and getNumberOfWheels from EngineVehicle
    }

    // Main method to test substitution behavior
    public static void main(String[] args) {
        L_iskovSubstitution instance = new L_iskovSubstitution();

        // Testing the behavior of the base class and subclasses
        Vehicle myBike = instance.new Bicycle();
        System.out.println("Bicycle wheels: " + myBike.getNumberOfWheels()); // Expected 2

        Vehicle myCar = instance.new Car();
        System.out.println("Car wheels: " + myCar.getNumberOfWheels()); // Expected 4

        Vehicle myMotorCycle = instance.new MotorCycle();
        System.out.println("Motorcycle wheels: " + myMotorCycle.getNumberOfWheels()); // Expected 4

        EngineVehicle myEngineVehicle = instance.new Car();
        System.out.println("Car has engine: " + myEngineVehicle.hasEngine()); // Expected true
    }
}

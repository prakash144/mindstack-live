/*

        +---------------------------------------------------+
        |                      Client (Main)                |
        +---------------------------------------------------+
                                    |
                                    v
                +-------------------------------------+
                |        CarFactory (Abstract)        |
                +-------------------------------------+
                      /                         \
                      v                          v
        +------------------------+     +------------------------+
        |   LuxuryCarFactory     |     |  OrdinaryCarFactory    |
        |  (Concrete Factory)    |     |  (Concrete Factory)    |
        +------------------------+     +------------------------+
                  |                           |
                  |                           |
                  v                           v
        +------------------------+     +------------------------+
        |      LuxuryCar         |     |     OrdinaryCar        |
        |   (Concrete Product)   |     |   (Concrete Product)   |
        +------------------------+     +------------------------+

Key Relationships:
- **is-a**: `LuxuryCarFactory` and `OrdinaryCarFactory` are implementations of the `CarFactory` interface.
- **has-a**: Each factory creates specific products (LuxuryCar and OrdinaryCar), demonstrating a **has-a** relationship.

 */

public class Main {
    public static void main(String[] args) {

        // creating luxury car
        CarFactory luxuryCarFactory = new LuxuryCarFactory();
        Car luxuryCar = luxuryCarFactory.createCar();
        luxuryCar.drive();

        // creating ordinary car
        CarFactory ordinaryCarFactory = new OrdinaryCarFactory();
        Car ordinaryCar = ordinaryCarFactory.createCar();
        ordinaryCar.drive();
    }
}
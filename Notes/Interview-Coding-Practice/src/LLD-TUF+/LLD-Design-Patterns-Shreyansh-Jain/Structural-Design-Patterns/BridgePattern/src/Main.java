/*

                            +-------------------+
                            |  BreathingMethod  |
                            | (Implementor)     |
                            +-------------------+
                            | + breathe(): String|
                            +---------+---------+
                                      |
                                      |
                +---------------------+---------------------+
                |                                           |
     +----------+------------+                     +-----------------------+
     |      Lungs            |                     |       Gills           |
     | (ConcreteImplementor) |                     | (ConcreteImplementor) |
     +-----------------------+                     +-----------------------+
     | + breathe()           |                     | + breathe()           |
     +-----------------------+                     +-----------------------+
                |                                           |
                |                                           |
                +---------------------+---------------------+
                                      |
                             +--------+--------+
                             |    Species      |
                             |    (Abstraction) |
                             +------------------+
                             | + breathe()      |
                             +---------+--------+
                                       |
                        +--------------+--------------+
                        |                             |
                +-------+--------------+              +------+---------------+
                |      Human           |              |      Fish            |
                | (RefinedAbstraction) |              | (RefinedAbstraction) |
                +----------------------+              +----------------------+
                | + breathe()          |              | + breathe()          |
                +----------------------+              +----------------------+


Bridge Design Pattern
    ├── Abstraction
    │       └── Species
    │           ├── Method: breathe()
    │           ├── Relationship: has-a (BreathingMethod)
    │           └── Refined Abstractions
    │               ├── Human
    │               │   └── Method: breathe()
    │               └── Fish
    │                   └── Method: breathe()
    │
    ├── Implementor
    │       └── BreathingMethod
    │           └── Method: breathe()
    │
    ├── Concrete Implementors
    │       ├── Lungs
    │       │   └── Method: breathe()
    │       └── Gills
    │           └── Method: breathe()
    │
    ├── Relationships
    │       ├── is-a: Human/Fish is a Species
    │       └── has-a: Species has a BreathingMethod
    │
    └── Key Takeaways
            ├── Decouples abstraction from implementation
            └── Allows independent evolution of species and breathing methods


 */


public class Main {
    public static void main(String[] args) {
        // Human breathes with lungs
        Species human = new Human(new Lungs());
        human.breathe();  // Output: Human is Breathing with lungs

        // Fish breathes with gills
        Species fish = new Fish(new Gills());
        fish.breathe();  // Output: Fish is Breathing with gills
    }
}
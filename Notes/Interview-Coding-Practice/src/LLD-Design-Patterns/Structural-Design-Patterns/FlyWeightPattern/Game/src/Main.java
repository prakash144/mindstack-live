/*

                     +-----------------------+
                     |      Main Client      |
                     +-----------------------+
                              |
                              v
                   +-----------------------+
                   |   RoboticFactory      |   <--- Flyweight Factory
                   +-----------------------+
                              |
                              v
      +----------------+      +----------------+
      | HumanoidRobot  |      |  RoboticDog    |   <--- Flyweight Objects
      +----------------+      +----------------+
         |   (shared)           |   (shared)
         v                      v
     +-----------+          +-----------+
     |  Sprites  |          |  Sprites  |    <--- Intrinsic State (shared)
     +-----------+          +-----------+


 */
public class Main {
    public static void main(String[] args) {
        IRobot humanoidRobot1 = RoboticFactory.createRobot("HUMANOID");
        humanoidRobot1.display(1, 2);
        IRobot humanoidRobot2 = RoboticFactory.createRobot("HUMANOID");
        humanoidRobot2.display(10, 20);

        IRobot roboDog1 = RoboticFactory.createRobot("ROBOTICDOG");
        roboDog1.display(2, 9);

        IRobot roboDog2 = RoboticFactory.createRobot("ROBOTICDOG");
        roboDog2.display(3, 8);

    }
}
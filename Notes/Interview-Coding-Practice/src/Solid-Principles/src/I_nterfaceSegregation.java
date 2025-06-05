/**
 * This class demonstrates the Interface Segregation Principle (ISP).
 * ISP states that a client should not be forced to implement methods it doesn't use.
 * <p>
 * FLOWCHART:
 * <p>
 *    +------------------+                +------------------+
 *    |  WaiterInterface  |                |   ChefInterface  |
 *    +------------------+                +------------------+
 *    | + serve()         |                | + cookFood()     |
 *    | + takeOrder()     |                | + decideMenu()   |
 *    +------------------+                +------------------+
 *           |                                   |
 *    +-------------+                     +--------------+
 *    |   Waiter    |                     |    Chef      |
 *    +-------------+                     +--------------+
 *    | + serve()   |                     | + cookFood() |
 *    | + takeOrder()|                     | + decideMenu()|
 *    +-------------+                     +--------------+
 * <p>
 * - Each interface defines only relevant methods for each role.
 * - Waiter implements WaiterInterface (serve, takeOrder).
 * - Chef would implement ChefInterface (cookFood, decideMenu).
 */

public class I_nterfaceSegregation {

    // Defines waiter-related actions
    interface WaiterInterface {
        void serve();
        void takeOrder();
    }

    // Defines chef-related actions
    interface ChefInterface {
        void cookFood();
        void decideMenu();
    }

    // Implements waiter actions
    class Waiter implements WaiterInterface {
        public void serve() {
            System.out.println("Serving the Customer");
        }

        public void takeOrder() {
            System.out.println("Taking Order");
        }
    }

    // Example of how Chef class would implement ChefInterface
    class Chef implements ChefInterface {
        public void cookFood() {
            System.out.println("Cooking Food");
        }

        public void decideMenu() {
            System.out.println("Deciding Menu");
        }
    }

    // Main method to run the code
    public static void main(String[] args) {
        I_nterfaceSegregation instance = new I_nterfaceSegregation();

        Waiter waiter = instance.new Waiter();
        waiter.serve();
        waiter.takeOrder();

        Chef chef = instance.new Chef();
        chef.cookFood();
        chef.decideMenu();
    }
}

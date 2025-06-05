/*

                     +------------------------+
                     |       Main (Client)    |
                     +------------------------+
                                   |
                                   v
                     +------------------------+
                     |      BasePizza         |
                     +------------------------+
                                   |
             +------------------+  |  +-----------------------+
             |                  |  v  |                       |
        +------------+        +-----------+      +------------------+
        | Margherita |        | Farmhouse |      |    VegDelight    |
        +------------+        +-----------+      +------------------+
              ^                   ^                    ^
              |                   |                    |
              |                   |                    |
              +-------------------+--------------------+
                                   |
                                   |
                           +------------------------------+
                           |  ToppingDecorator (Abstract) |
                           +------------------------------+
                                   |
                      +-------------+----------------------+
                      |                                    |
            +--------------------+              +-------------------+
            |  ExtraCheese       |              |   Mushroom        |
            +--------------------+              +-------------------+
                   ^                                    ^
                   |                                    |
                   +------------------------------------+
                                   |
                                   v
                           +-----------------------+
                           |      BasePizza        |
                           +-----------------------+

Explanation of Relationships:

"Is-a" Relationship:
        Margherita, Farmhouse, and VegDelight are a type of BasePizza.
        This is an "is-a" relationship because they extend from the abstract class BasePizza.

"Has-a" Relationship:
    ExtraCheese and Mushroom have a BasePizza.
    This is a "has-a" relationship because they take a BasePizza object as a constructor parameter,
    meaning they wrap or decorate a pizza with extra toppings, thus enhancing functionality without
    modifying the original object.

 */



import Pizza.*;
import Decorator.*;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new Margherita());
        System.out.println("Cost for Margherita topping with Extra Cheese: "+ pizza.cost());

        pizza = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println("Cost for Margherita topping with Extra Cheese and mushroom: "+ pizza.cost());
    }
}
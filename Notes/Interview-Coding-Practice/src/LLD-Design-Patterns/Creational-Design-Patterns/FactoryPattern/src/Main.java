/*

        +----------------------+
        |  Shape (Interface)   |
        +----------------------+
                   ^
                   |
        +----------------------+       +----------------------+
        |   Circle (Concrete)  |       | Rectangle (Concrete) |
        +----------------------+       +----------------------+
                   ^                       ^
                   |                       |
             +-----------------------------------+
             |           ShapeFactory            |   <---- has-a relationship
             +-----------------------------------+
             | getShape(String shapeType) Method |
             +-----------------------------------+
                           |
                           v
             +---------------------+
             | Client (Main Class) |   <---- is-a relationship with Shape
             +---------------------+

Key Points:
has-a relationship: ShapeFactory has knowledge of Shape creation (can return either Circle or Rectangle).
is-a relationship: Both Circle and Rectangle are instances of Shape.

 */

public class Main {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();

    }
}
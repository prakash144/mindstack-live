public class ShapeFactory {
    Shape getShape(String shapeType) {
        return switch (shapeType) {
            case "rectangle" -> new Rectangle();
            case "circle" -> new Circle();
            default -> null;
        };
    }
}

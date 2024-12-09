package FactoryMethod;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = new ShapeFactory().getShape("CIRCLE");
        circle.draw();
        Shape square = new ShapeFactory().getShape("SQUARE");
        square.draw();
        Shape rectangle = new ShapeFactory().getShape("RECTANGLE");
        rectangle.draw();
    }
}

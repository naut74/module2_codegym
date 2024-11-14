package circleAndCylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "white";

    public Circle() {}

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle has radius = "
                + radius
                + ", color = "
                + getColor()
                + ", Area = "
                + getArea()
                + ", Perimeter = "
                + getPerimeter();
    }
}

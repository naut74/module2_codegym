package circleAndCylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {}

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getAreaCylinder() {
        return  Math.PI * getRadius() * getRadius() * height;
    }

    public double getPerimeterCylinder() {
        return 2 * Math.PI * getRadius() * 2 + (getRadius() * height);
    }

    @Override
    public String toString() {
        return "Cylinder has radius = "
                + this.getRadius()
                + ", color = "
                + getColor()
                + ", Area = "
                + getAreaCylinder()
                + ", Perimeter = "
                + getPerimeterCylinder();
    }
}

package overrideMethod;

public class CircleFromSimpleGeometricObject extends SimpleGeometricObject {
    private double radius = 5;

    public CircleFromSimpleGeometricObject() {};

    public CircleFromSimpleGeometricObject(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return super.toString() + "\nradius is " + radius;
    }
}
package Resizeable;

public class Square extends Rectangle {

    public Square() {}

    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    @Override
    public void resize(double percent) {
        setSide(getSide() + getSide() * percent / 100);
    }

    @Override
    public String toString() {
        return "Square[side=" + getSide() + ", area=" + getArea() + "]";
    }
}

package colorable.shape.src.com.codegym;

public class Square extends Rectangle implements Colorable{

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

    private void setHeight(double side) {
    }

    @Override
    public String toString() {
        return "Square[side="
                + getSide()
                + ", area="
                + getArea()
                + "]"
                ;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four side.");
    }
}

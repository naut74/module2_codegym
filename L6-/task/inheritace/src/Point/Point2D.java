package Point;

public class Point2D {
    float x = 0.0f;
    float y = 0.0f;

    public Point2D() {}

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX() {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY() {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{x, y};
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x = " + x +
                ", y = " + y +
                '}';
    }
}

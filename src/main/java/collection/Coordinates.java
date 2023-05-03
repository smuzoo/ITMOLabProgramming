package collection;

public class Coordinates {
    private int x; //Значение поля должно быть больше -661
    private double y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public Coordinates(int x, double y) {
        this.x = x;
        this.y = y;
    }

}

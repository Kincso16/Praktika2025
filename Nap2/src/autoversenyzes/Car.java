package autoversenyzes;

import java.awt.*;

public class Car {
    private int x;
    private Color color;

    public Car(Color color) {
        this.color = color;
    }

    public void move(int dx) {
        x += dx;
    }
    public int getX() {
        return x;
    }

    public Color getColor() {
        return color;
    }
}

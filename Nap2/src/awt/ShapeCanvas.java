package awt;

import java.awt.*;

public class ShapeCanvas extends Canvas {
    private boolean isFilled;
    private String shape;
    private String color;

    public ShapeCanvas() {
        isFilled = false;
        shape = "Circle";
        color = "Red";

        setBackground(Color.lightGray);
    }

    public void refresh(boolean isFilled, String shape, String color) {
        this.isFilled = isFilled;
        this.shape = shape;
        this.color = color;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        switch (color) {
            case "Red":
                g.setColor(Color.RED);
                break;
            case "Blue":
                g.setColor(Color.BLUE);
                break;
        }
        switch (shape) {
            case "Circle":
                if (isFilled) {
                    g.fillOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
                } else {
                    g.drawOval(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
                }
                break;
            case "Square":
                if (isFilled) {
                    g.fillRect(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
                } else {
                    g.drawRect(getWidth() / 2 - 50, getHeight() / 2 - 50, 100, 100);
                }
                break;
        }
    }
}

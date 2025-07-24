package swing;

import javax.swing.*;
import java.awt.*;

public class JShapeCanvas extends JPanel {
    private String shape;
    private boolean isFilled;
    private Color color;
    private int size;

    public JShapeCanvas() {
        shape="Circle";
        isFilled=false;
        color=Color.WHITE;
        size=50;

        setBackground(Color.LIGHT_GRAY);
    }

    public void refresh(String shape,boolean isFilled,Color color,int size) {
        this.shape=shape;
        this.isFilled=isFilled;
        this.color=color;
        this.size=size;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size * 12, size * 12);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        switch (shape) {
            case "Circle":
                if(!isFilled){
                    g.drawOval(getWidth()/2-size*4, getHeight()/2-size*4, size*8, size*8);
                }else{
                    g.fillOval(getWidth()/2-size*4, getHeight()/2-size*4, size*8, size*8);
                }
                break;
            case "Square":
                if(!isFilled){
                    g.drawRect(getWidth()/2-size*4, getHeight()/2-size*4, size*8, size*8);
                }else{
                    g.fillRect(getWidth()/2-size*4, getHeight()/2-size*4, size*8, size*8);
                }
                break;
        }
    }
}

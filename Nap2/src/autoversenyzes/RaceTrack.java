package autoversenyzes;

import javax.swing.*;
import java.awt.*;

public class RaceTrack extends JPanel {
    private Car[] cars;

    public RaceTrack(Car[] cars) {
        this.cars = cars;
        setBackground(Color.GREEN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0;i<cars.length;i++){
            g.setColor(cars[i].getColor());
            g.fillRect(cars[i].getX(),i*20,20,10);
        }
    }
}

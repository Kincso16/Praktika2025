package awt;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        ShapeFrame windowFrame = new ShapeFrame();
        windowFrame.setBounds(100,100,1000,1000);
        windowFrame.setVisible(true);
        windowFrame.setResizable(false);
        windowFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
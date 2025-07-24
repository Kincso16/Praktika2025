package swing;

import javax.swing.*;

public class JMain {
    public static void main(String[] args) {
        JShapeFrame jwindowFrame = new JShapeFrame();
        jwindowFrame.setBounds(100,100,1000,1000);
        jwindowFrame.setVisible(true);
        jwindowFrame.setResizable(false);
        jwindowFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

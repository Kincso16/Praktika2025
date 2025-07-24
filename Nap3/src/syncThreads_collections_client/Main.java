package syncThreads_collections_client;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CounterFrame counterFrame = new CounterFrame();
        counterFrame.setBounds(100, 100, 500, 500);
        counterFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        counterFrame.setVisible(true);
    }
}
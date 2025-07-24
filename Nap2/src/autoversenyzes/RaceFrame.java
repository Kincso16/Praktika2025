package autoversenyzes;

import javax.swing.*;
import java.awt.*;

public class RaceFrame extends JFrame {
    private RaceTrack track;
    private JPanel contentPanel;

    public RaceFrame(RaceTrack track) {
        this.track = track;
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(track,BorderLayout.CENTER);
        setContentPane(contentPanel);
    }

}

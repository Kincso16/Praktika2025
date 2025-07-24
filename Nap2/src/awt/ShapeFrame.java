package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeFrame extends Frame {
    private Choice shapeChoice;
    private Choice colorChoice;
    private Checkbox filledCheckbox;
    private Button drawButton;

    private Panel controlPanel;
    private ShapeCanvas canvas;

    public ShapeFrame() {
        shapeChoice = new Choice();
        colorChoice = new Choice();
        filledCheckbox = new Checkbox("Filled");
        drawButton = new Button("Draw");
        controlPanel = new Panel();
        canvas = new ShapeCanvas();

        shapeChoice.add("Circle");
        shapeChoice.add("Square");

        colorChoice.add("Red");
        colorChoice.add("Blue");

        controlPanel.add(shapeChoice);
        controlPanel.add(colorChoice);
        controlPanel.add(filledCheckbox);
        controlPanel.add(drawButton);

        add(controlPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.refresh(filledCheckbox.getState(),shapeChoice.getSelectedItem(),colorChoice.getSelectedItem());
            }
        });
    }
}

package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class JShapeFrame extends JFrame {
    private JComboBox<String> shapeCombo;
    private JCheckBox filledCheck;
    private JSlider sizeSlider;
    private JButton drawButton;
    private JColorChooser colorChooser;
    private JScrollPane scrollPane;
    private JMenu fileMenu;
    private JMenuBar menuBar;
    private JMenuItem loadMenuItem;
    private JMenuItem saveMenuItem;

    private JPanel contentPanel;
    private JPanel buttonsPanel;

    private JShapeCanvas canvas;

    public JShapeFrame() {
        shapeCombo = new JComboBox<>();
        filledCheck = new JCheckBox("Filled");
        sizeSlider = new JSlider();
        drawButton = new JButton("Draw");
        colorChooser = new JColorChooser();
        canvas = new JShapeCanvas();
        scrollPane = new JScrollPane(canvas);

        fileMenu = new JMenu("File");
        menuBar = new JMenuBar();
        saveMenuItem = new JMenuItem("Save");
        loadMenuItem = new JMenuItem("Load");

        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

        contentPanel = new JPanel();
        buttonsPanel = new JPanel();

        shapeCombo.addItem("Square");
        shapeCombo.addItem("Circle");

        buttonsPanel.add(shapeCombo);
        buttonsPanel.add(filledCheck);
        buttonsPanel.add(sizeSlider);
        buttonsPanel.add(drawButton);

        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(buttonsPanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(colorChooser, BorderLayout.SOUTH);

        setContentPane(contentPanel);

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.refresh((String) shapeCombo.getSelectedItem(), filledCheck.isSelected(), colorChooser.getColor(), sizeSlider.getValue());
                scrollPane.revalidate();
            }
        });

        loadMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(JShapeFrame.this);
                loadImage(chooser.getSelectedFile());
            }
        });
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showSaveDialog(JShapeFrame.this);
                saveImage(chooser.getSelectedFile());
            }
        });
    }

    private void loadImage(File file) {
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            shapeCombo.setSelectedItem(br.readLine());
            filledCheck.setSelected(Boolean.parseBoolean(br.readLine()));
            colorChooser.setColor(new Color(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
            sizeSlider.setValue(Integer.parseInt(br.readLine()));
            canvas.refresh((String)shapeCombo.getSelectedItem(),filledCheck.isSelected(),colorChooser.getColor(),sizeSlider.getValue());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error opening file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveImage(File file) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(shapeCombo.getSelectedItem().toString() + "\n");
            bw.write(filledCheck.isSelected() + "\n");
            bw.write(colorChooser.getColor().getRed() + "\n");
            bw.write(colorChooser.getColor().getGreen() + "\n");
            bw.write(colorChooser.getColor().getBlue() + "\n");
            bw.write(sizeSlider.getValue() + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error while trying to save file!", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}

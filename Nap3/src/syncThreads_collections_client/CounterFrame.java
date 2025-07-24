package syncThreads_collections_client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterFrame extends JFrame implements CounterListener {
    private JButton startButton;
    private JButton stopButton;
    private JButton suspendButton;
    private JButton resumeButton;
    private JLabel counterLabel;
    private JPanel contentPanel;
    private Counter counter;
    private CounterClient counterClient;

    public CounterFrame() {
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        suspendButton = new JButton("Suspend");
        resumeButton = new JButton("Resume");

        counterLabel = new JLabel("0");
        contentPanel = new JPanel();

        contentPanel.add(startButton);
        contentPanel.add(stopButton);
        contentPanel.add(suspendButton);
        contentPanel.add(resumeButton);
        contentPanel.add(counterLabel);

        setContentPane(contentPanel);

        counter = new Counter();

        enableButtons(true,false,false,false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButtons(false,true,true,false);
                counter.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButtons(true,false,false,false);
                counter.stop();
            }
        });

        suspendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButtons(false,true,false,true);
                counter.suspend();
            }
        });

        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButtons(false,true,true,false);
                counter.resume();
            }
        });
        counter.addCounterListener(this);
        counter.addCounterListener(new CounterListener() {

            @Override
            public void counterChanged(CounterEvent event) {
                System.out.println(event.getValue());
            }
        });
        counterClient=new CounterClient();
    }

    private void enableButtons(boolean start,boolean stop,boolean suspend,boolean resume) {
        startButton.setEnabled(start);
        stopButton.setEnabled(stop);
        suspendButton.setEnabled(suspend);
        resumeButton.setEnabled(resume);
    }

    public void refreshLable(int value){
        counterLabel.setText(value+"");
    }

    @Override
    public void counterChanged(CounterEvent event) {
        refreshLable(event.getValue());
        if(event.getValue()%5==0){
            counterClient.sendMessage(event.getValue()+"");
        }
    }
}

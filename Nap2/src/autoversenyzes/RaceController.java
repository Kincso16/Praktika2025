package autoversenyzes;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RaceController {
    public static boolean isRaceOver;
    public static final int TRACK_LENGTH = 800;

    private Car[] cars;
    private CarController[] carControllers;
    private RaceTrack raceTrack;
    private TrackRefresher trackRefresher;
    private RaceFrame raceFrame;

    public void initRace(int n) {
        cars = new Car[n];
        carControllers = new CarController[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            carControllers[i] = new CarController(cars[i]);
        }
        raceTrack = new RaceTrack(cars);
        trackRefresher = new TrackRefresher(raceTrack);
        raceFrame = new RaceFrame(raceTrack);

        raceFrame.setBounds(0, 0, 1000, 1000);
        raceFrame.setVisible(true);
        raceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startRace(){
        for(int i = 0; i < cars.length; i++){
            carControllers[i].start();
        }
        trackRefresher.start();
    }

    public static void main(String[] args) {
        RaceController raceController = new RaceController();
        raceController.initRace(10);
        raceController.startRace();
    }
}
//hazi: feluletrol lehessen valasztani az autok szamat es egy start gomb...addig tartson amig beer mindenki es hogy irassuk ki ki hanyadiknak ert be...
//szepiteni finish line berakas es hasonlok
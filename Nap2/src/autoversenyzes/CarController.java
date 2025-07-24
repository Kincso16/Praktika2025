package autoversenyzes;

import java.util.Random;

public class CarController  extends Thread{
    private Car car;

    public CarController(Car car) {
        this.car = car;
    }
    @Override
    public void run() {
        Random rand = new Random();
        while(!RaceController.isRaceOver && car.getX()<RaceController.TRACK_LENGTH){
            car.move(rand.nextInt(5));
            try {
                Thread.sleep(rand.nextInt(10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(car.getX()>=RaceController.TRACK_LENGTH){
            RaceController.isRaceOver = true;
        }

    }
}

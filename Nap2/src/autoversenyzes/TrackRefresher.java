package autoversenyzes;

public class TrackRefresher  extends Thread{
    private RaceTrack track;
    public TrackRefresher(RaceTrack track) {
        this.track = track;
    }
    @Override
    public void run() {
        while(!RaceController.isRaceOver){
            track.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

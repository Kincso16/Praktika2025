package syncThreads_collections_client;

import java.util.LinkedList;
import java.util.List;

public class Counter implements Runnable {
    private int value;
    private volatile Thread controlThread;
    private volatile boolean isSuspended;
    private List<CounterListener> listeners;

    public Counter() {
        listeners = new LinkedList<CounterListener>();
    }

    public void start() {
        value = 0;
        isSuspended = false;
        controlThread = new Thread(this);
        controlThread.start();
    }

    public void stop() {
        Thread tmp = controlThread;
        controlThread = null;
        tmp.interrupt();
    }

    public void suspend() {
        isSuspended = true;
    }

    public synchronized void resume() {
        isSuspended = false;
        notifyAll();
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();

        while (currentThread == controlThread) { //teljesul mig valaki kivulrol stopot nem hivott
            while (isSuspended) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            CounterEvent ce = new CounterEvent(this, value++);
            synchronized (this) {
                for (CounterListener listener : listeners) {
                    listener.counterChanged(ce);
                }
            }
        }
    }

    public synchronized void addCounterListener(CounterListener listener) {
        listeners.add(listener);
    }

    public synchronized void removeCounterListener(CounterListener listener) {
        listeners.remove(listener);
    }
}

package syncThreads_collections_client;

import java.util.EventListener;

public interface CounterListener extends EventListener {
    void counterChanged( CounterEvent event);

}

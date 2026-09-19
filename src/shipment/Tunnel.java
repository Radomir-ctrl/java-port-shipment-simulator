package shipment;

import shipment.ship.Ship;
import shipment.ship.types.Type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tunnel {
    private static final int TUNNEL_LIMIT = 5;
    private final List<Ship> store = new ArrayList<>();
    private boolean generationFinished;

    public synchronized void add(Ship barge) throws InterruptedException {
        while (store.size() >= TUNNEL_LIMIT) {
            wait();
        }
        store.add(barge);
        System.out.printf("%s The barge arrived in tunnel: %s, %s, %s%n",
                store.size(), barge.getType(), barge.getSize(), barge.getCount());
        notifyAll();
    }

    public synchronized Ship get(Type shipType) throws InterruptedException {
        while (true) {
            Iterator<Ship> ships = store.iterator();
            while (ships.hasNext()) {
                Ship ship = ships.next();
                if (ship.getType() == shipType) {
                    ships.remove();
                    System.out.println(store.size() + " The barge left the tunnel "
                            + Thread.currentThread().getName());
                    notifyAll();
                    return ship;
                }
            }
            if (generationFinished) {
                return null;
            }
            wait();
        }
    }

    public synchronized void finishGeneration() {
        generationFinished = true;
        notifyAll();
    }
}

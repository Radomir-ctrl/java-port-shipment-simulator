package shipment.generator;

import shipment.Tunnel;
import shipment.ship.Ship;
import shipment.ship.types.Type;

public class Jetty implements Runnable {
    private final Tunnel tunnel;
    private final Type type;

    public Jetty(Tunnel tunnel, Type type) {
        this.tunnel = tunnel;
        this.type = type;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Jetty " + type);
        try {
            while (true) {
                Thread.sleep(5000);
                Ship barge = tunnel.get(type);
                if (barge == null) {
                    return;
                }
                Thread.sleep(1000);
                barge.add(10);
                System.out.println(barge.getCount() + " The barge is full. "
                        + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

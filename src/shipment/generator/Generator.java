package shipment.generator;

import shipment.Tunnel;
import shipment.ship.Ship;
import shipment.ship.types.Size;
import shipment.ship.types.Type;

import java.util.Random;

public class Generator implements Runnable {
    private final Tunnel tunnel;
    private final int shipCount;
    private final Random random = new Random();

    public Generator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Generator");
        try {
            for (int count = 0; count < shipCount; count++) {
                tunnel.add(new Ship(getRandomSize(), getRandomType()));
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            tunnel.finishGeneration();
        }
    }

    private Type getRandomType() {
        Type[] types = Type.values();
        return types[random.nextInt(types.length)];
    }

    private Size getRandomSize() {
        Size[] sizes = Size.values();
        return sizes[random.nextInt(sizes.length)];
    }
}

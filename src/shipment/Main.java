package shipment;

import shipment.generator.Generator;
import shipment.generator.Jetty;
import shipment.ship.types.Type;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();
        Generator generator = new Generator(tunnel, 10);

        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(generator);
        service.execute(new Jetty(tunnel, Type.FOOD));
        service.execute(new Jetty(tunnel, Type.DRINK));
        service.execute(new Jetty(tunnel, Type.CLOTHES));
        service.shutdown();
    }
}

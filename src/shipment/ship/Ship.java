package shipment.ship;

import shipment.ship.types.Size;
import shipment.ship.types.Type;

public class Ship {
    private int count;
    private final Size size;
    private final Type type;

    public Ship(Size size, Type type) {
        this.size = size;
        this.type = type;
    }

    public void add(int count) {
        this.count += count;
    }

    public boolean countCheck() {
        return count < size.getValue();
    }

    public int getCount() {
        return count;
    }

    public Size getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }
}

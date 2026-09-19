# Multithreaded Port Shipment Simulator

A Java console application that simulates ships arriving at a port and being processed concurrently by multiple jetties. A generator creates ships of different sizes and cargo types, a bounded tunnel holds arriving ships, and each jetty handles one cargo type.

The project demonstrates Java, object-oriented programming, multithreading, `ExecutorService`, synchronized methods, `wait()`/`notifyAll()`, collections, and enums.

## Build and run

Requires a JDK. From this directory:

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build src/shipment/Main.java src/shipment/Tunnel.java src/shipment/generator/*.java src/shipment/ship/*.java src/shipment/ship/types/*.java
java -cp build shipment.Main
```

The generator produces ten ships with a ten-second pause between arrivals. The program exits after all ships are processed.

Originally developed as part of a Java programming course and later cleaned up for publication.

**Author:** Radomyr Karpan

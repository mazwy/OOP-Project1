import containers.*;
import exceptions.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ship {
    // Each ship has a different capacity and deadweight defined by:
    private int maxNumToxicExplosiveContainers,
                maxNumHeavyContainers,
                maxNumNetworkConnectedContainers,
                maxNumAllContainers,
                maxWeightLoad;
    private int currentNumToxicExplosiveContainers = 0,
                currentNumHeavyContainers = 0,
                currentNumNetworkConnectedContainers = 0,
                currentNumAllContainers = 0,
                currentWeightLoad = 0;
    private String name, homePort, origin, destination;
    private int id;
    private static int counter = 0;

    // Each ship stores basic information about itself
    // (unique identification number assigned automatically when creating the object,
    // name, home port, transport origin and destination)
    public Ship(String name, String homePort,
                int maxNumToxicExplosiveContainers, int maxNumHeavyContainers,
                int maxNumNetworkConnectedContainers, int maxNumAllContainers,
                int maxWeightLoad) {
        this.name = name;
        this.homePort = homePort;
        this.origin = origin;
        this.destination = destination;
        this.maxNumToxicExplosiveContainers = maxNumToxicExplosiveContainers;
        this.maxNumHeavyContainers = maxNumHeavyContainers;
        this.maxNumNetworkConnectedContainers = maxNumNetworkConnectedContainers;
        this.maxNumAllContainers = maxNumAllContainers;
        this.maxWeightLoad = maxWeightLoad;

        id = counter++;
    }

    // Loading a container onto the ship, checking capacity
   public void loadContainer(Container container) throws CapacityException {
        int newWeight = currentWeightLoad + container.getWeight();

        if (newWeight <= maxWeightLoad && currentNumAllContainers < maxNumAllContainers &&
            currentNumHeavyContainers < maxNumHeavyContainers &&
            currentNumNetworkConnectedContainers < maxNumNetworkConnectedContainers &&
            currentNumToxicExplosiveContainers < maxNumToxicExplosiveContainers) {
            switch (container.getType()) {
                case "Standard", "Liquid" -> currentNumAllContainers++;
                case "Heavy" -> {
                    currentNumHeavyContainers++;
                    currentNumAllContainers++;
                }
                case "Refrigerated" -> {
                    currentNumHeavyContainers++;
                    currentNumNetworkConnectedContainers++;
                    currentNumAllContainers++;
                }
                case "Explosive" -> {
                    currentNumToxicExplosiveContainers++;
                    currentNumAllContainers++;
                }
                case "ToxicPowdery", "ToxicLiquid" -> {
                    currentNumHeavyContainers++;
                    currentNumAllContainers++;
                    currentNumToxicExplosiveContainers++;
                }
            }
            currentWeightLoad = newWeight;
        } else {
            throw new CapacityException();
        }

    }

    // Unloading, checking if there is a container available
    public void unloadContainer(Container container) throws ContainerUnavailableException {
        if (currentNumAllContainers > 0 &&
                currentNumHeavyContainers > 0 &&
                currentNumNetworkConnectedContainers > 0 &&
                currentNumToxicExplosiveContainers > 0) {
            switch (container.getType()) {
                case "standard", "liquid" -> currentNumAllContainers--;
                case "heavy" -> {
                    currentNumHeavyContainers--;
                    currentNumAllContainers--;
                }
                case "refrigerated" -> {
                    currentNumNetworkConnectedContainers--;
                    currentNumHeavyContainers--;
                    currentNumAllContainers--;
                }
                case "explosive" -> {
                    currentNumToxicExplosiveContainers--;
                    currentNumAllContainers--;
                }
                case "toxicPowdery", "toxicLiquid" -> {
                    currentNumHeavyContainers--;
                    currentNumAllContainers--;
                    currentNumToxicExplosiveContainers--;
                }
                default -> throw new IllegalStateException("Unexpected value: " + container.getType());
            }

            currentWeightLoad -= container.getWeight();
        } else {
            throw new ContainerUnavailableException();
        }
    }

    @Override
    public String toString() {
        return "Ship " + name + " with id=" + id;
    }
}

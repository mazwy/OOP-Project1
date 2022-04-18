import Containers.*;
import Exceptions.*;

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
    private static int counter = 1;

    // Each ship stores basic information about itself
    // (unique identification number assigned automatically when creating the object,
    // name, home port, transport origin and destination)

    public Ship(String name, String homePort, String origin, String destination,
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

    // Getters:


    // Loading a container onto the ship, checking capacity
   public void loadContainer() throws ShipCapacityException {
        if (currentWeightLoad < maxWeightLoad && currentNumAllContainers < maxNumAllContainers &&
            currentNumHeavyContainers < maxNumHeavyContainers &&
            currentNumNetworkConnectedContainers < maxNumNetworkConnectedContainers &&
            currentNumToxicExplosiveContainers < maxNumToxicExplosiveContainers) {
            switch () {
                case "standard", "liquid" -> currentNumAllContainers++;
                case "heavy" -> {
                    currentNumHeavyContainers++;
                    currentNumAllContainers++;
                }
                case "refrigerated" -> {
                    currentNumHeavyContainers++;
                    currentNumNetworkConnectedContainers++;
                    currentNumAllContainers++;
                }
                case "explosive" -> {
                    currentNumToxicExplosiveContainers++;
                    currentNumAllContainers++;
                }
                case "toxicPowdery", "toxicLiquid" -> {
                    currentNumHeavyContainers++;
                    currentNumAllContainers++;
                    currentNumToxicExplosiveContainers++;
                }
            }

            currentWeightLoad += Container.getGrossWeight;
        }
        else {
            throw new ShipCapacityException();
        }

    }

    @Override
    public String toString() {
        return "Ship " + name;
    }
}

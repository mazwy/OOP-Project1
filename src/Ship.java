public class Ship {
    // Each ship has a different capacity and deadweight defined by:
    private int maxNumToxicExplosiveContainers;
    private int maxNumHeavyContainers;
    private int maxNumNetworkConnectedContainers;
    private int maxNumAllContainers;
    private int maxWeightLoad;

    // Each ship stores basic information about itself
    // (unique identification number assigned automatically when creating the object,
    // name, home port, transport origin and destination).
    public Ship(int maxNumToxicExplosiveContainers, int maxNumHeavyContainers,
                int maxNumNetworkConnectedContainers, int maxNumAllContainers,
                int maxWeightLoad) {
        this.maxNumToxicExplosiveContainers = maxNumToxicExplosiveContainers;
        this.maxNumHeavyContainers = maxNumHeavyContainers;
        this.maxNumNetworkConnectedContainers = maxNumNetworkConnectedContainers;
        this.maxNumAllContainers = maxNumAllContainers;
        this.maxWeightLoad = maxWeightLoad;

    }

    public void loadContainer() {
        switch ()
    }


}

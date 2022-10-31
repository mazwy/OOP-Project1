package containers;

import java.util.ArrayList;
import java.util.List;

public class StandardContainer implements Container{

    private Sender sender;
    private int tare, netWeight, grossWeight, id;
    private static int containerWeight = 4000, containerID = 0;

    public StandardContainer(Sender sender, int tare, int netWeight) {
        this.sender = sender;
        this.tare = tare;
        this.netWeight = netWeight;

        id = containerID++;

        grossWeight = netWeight + containerWeight;
        ArrayList<String> certificates = new ArrayList<>();
    }


    @Override
    public int getWeight() {
        return grossWeight;
    }

    @Override
    public String getType() {
        return "Standard";
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Standard Container id=" + id +
                ", sender='" + sender +
                ", tare=" + tare +
                ", weight=" + grossWeight;
    }
}
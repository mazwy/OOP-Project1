package Containers;

import java.util.ArrayList;

public class StandardContainer extends Container {
    private String sender;
    private int tare, netWeight, grossWeight;
    private static int containerWeight = 4000;

    public StandardContainer(String sender,
                             int tare, int netWeight) {
        String type = "Standard";
        this.sender = sender;
        this.tare = tare;
        this.netWeight = netWeight;
        grossWeight = netWeight + containerWeight;
        ArrayList<String> certificates = new ArrayList<>();
    }

    public int getGrossWeight() {
        return grossWeight;
    }

    @Override
    public String containerType() {
        return "Standard";
    }
}
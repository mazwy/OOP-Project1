package Containers;

import java.util.ArrayList;

public class StandardContainer {
    private String type;
    private String sender;
    private int tare;
    private int netWeight;
    private int grossWeight;

    public StandardContainer(String type, String sender,
                             int tare, int netWeight,
                             int grossWeight) {
        this.type = type;
        this.sender = sender;
        this.tare = tare;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        ArrayList<String> certificates = new ArrayList<>();
    }

    public String getType() {
        return type;
    }
}
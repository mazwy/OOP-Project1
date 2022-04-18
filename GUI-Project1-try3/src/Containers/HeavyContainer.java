package Containers;

public class HeavyContainer extends StandardContainer {
    public HeavyContainer(String type, String sender,
                          int tare, int netWeight,
                          int grossWeight) {
        super(type, sender, tare, netWeight, grossWeight);
    }

    @Override
    public String containerType() {
        return "Heavy";
    }
}

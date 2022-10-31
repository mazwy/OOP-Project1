package containers;

public class HeavyContainer extends StandardContainer {
    public HeavyContainer(Sender sender,
                          int tare, int netWeight) {
        super(sender, tare, netWeight);
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public String getType() {
        return "Heavy";
    }

    @Override
    public String toString() {
        return "Heavy Container ";
    }
}

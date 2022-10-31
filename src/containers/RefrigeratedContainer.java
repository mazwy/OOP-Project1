package containers;

public class RefrigeratedContainer extends HeavyContainer {
    boolean connected;

    public RefrigeratedContainer(Sender sender, int tare, int netWeight) {
        super(sender, tare, netWeight);

        connected = true;
    }

    public boolean isConnected() {
        return connected;
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public String getType() {
        return "Refrigerated";
    }

    @Override
    public String toString() {
        return "RefrigeratedContainer " +
                "connected=" + connected;
    }
}
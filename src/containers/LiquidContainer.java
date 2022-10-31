package containers;

public class LiquidContainer extends StandardContainer implements Liquid {
    public LiquidContainer(Sender sender, int tare, int netWeight) {
        super(sender, tare, netWeight);
    }
}

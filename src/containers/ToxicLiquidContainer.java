package containers;

public class ToxicLiquidContainer extends HeavyContainer implements Liquid {
    public ToxicLiquidContainer(Sender sender, int tare, int netWeight) {
        super(sender, tare, netWeight);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

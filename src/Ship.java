import Containers.Container;
import exception.IrresponsibleSenderWithDangerousGoodsException;

public class Ship {
    private int maxNumToxExpCon;
    private int maxNumHeavyCon;
    private int maxNumConnectedCon;
    private int maxNumAllCon;
    private int maxWeight;
    private int id;

    public Ship(int maxNumToxExpCon, int maxNumHeavyCon, int maxNumConnectedCon, int maxNumAllCon, int maxWeight) {
        this.maxNumToxExpCon = maxNumToxExpCon;
        this.maxNumHeavyCon = maxNumHeavyCon;
        this.maxNumConnectedCon = maxNumConnectedCon;
        this.maxNumAllCon = maxNumAllCon;
        this.maxWeight = maxWeight;
    }

    public void addContainer(Container container) throws IrresponsibleSenderWithDangerousGoodsException {

    }

    @Override
    public String toString() {
        return null;
    }
}

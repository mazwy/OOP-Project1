import containers.Container;
import exceptions.IrresponsibleSenderWithDangerousGoods;

import java.time.LocalDate;
import java.util.HashMap;

public class Warehouse {

    private String name;
    private int maxNumContainers;
    private int maxExplosiveStoreTime = 5;
    private int maxToxicLiquidStoreTime = 10;
    private int maxToxicPowderyStoreTime = 14;
    HashMap<Container, LocalDate> warehouse = new HashMap<>();

    public Warehouse(String name, int maxNumContainers) throws IrresponsibleSenderWithDangerousGoods {
        this.name = name;
        this.maxNumContainers = maxNumContainers;

    }

    public String getName() {
        return name;
    }

    public void disposeContainer(Container container) {

    }

    public int getMaxExplosiveStoreTime() {
        return maxExplosiveStoreTime;
    }

    public int getMaxToxicLiquidStoreTime() {
        return maxToxicLiquidStoreTime;
    }

    public int getMaxToxicPowderyStoreTime() {
        return maxToxicPowderyStoreTime;
    }

    @Override
    public String toString() {
        return "Warehouse " +
                "name=" + name +
                ", maxNumContainers=" + maxNumContainers +
                ", maxExplosiveStoreTime=" + maxExplosiveStoreTime +
                ", maxToxicLiquidStoreTime=" + maxToxicLiquidStoreTime +
                ", maxToxicPowderyStoreTime=" + maxToxicPowderyStoreTime;
    }
}

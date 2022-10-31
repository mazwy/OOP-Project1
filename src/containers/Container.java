package containers;

import java.util.ArrayList;

public interface Container {
    Sender sender = null;

    public int getWeight();

    public String getType();

    public int getID();

}

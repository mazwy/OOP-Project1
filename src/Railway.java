import containers.Container;
import exceptions.CapacityException;
import exceptions.ContainerUnavailableException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class Railway {
    private int id;
    private static int maxContainers = 10;
    private int currentNumContainers = 0;
    public HashMap<Container, LocalDate> rContainers = new HashMap<>();
    private List<Thread> threads;

    public Railway(int id, int currentNumContainers) {
        this.id = id;
        this.currentNumContainers = currentNumContainers;

    }

    public int getCurrentNumContainers() {
        return currentNumContainers;
    }


    //    public List<Thread> getThreads() {
//        return threads;
//    }

//    public void loadContainer(Container container) throws CapacityException, ContainerUnavailableException {
//        if (containers.isEmpty()) {
//           // throw new ContainerUnavailableException();
//        } else {
//            if (currentNumContainers < maxContainers) {
//                currentNumContainers++;
//                rContainers.put(container, );
//            } else
//                throw new CapacityException();
//        }
//    }
}

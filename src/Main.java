import containers.*;
import exceptions.CapacityException;
import exceptions.ContainerUnavailableException;
import exceptions.IrresponsibleSenderWithDangerousGoods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static ArrayList<Container> unsignedContainers = new ArrayList<>();
    public static ArrayList<Ship> ships = new ArrayList<>();
    public static int containerCounter = 0;
    public static Map<Ship, List<Container>> shipMap = new LinkedHashMap<>();
    public static Map<Warehouse, List<Container>> warehouseMap = new LinkedHashMap<>();
    public static ArrayList<Sender> senders = new ArrayList<>();

    public static void main(String[] args) throws IrresponsibleSenderWithDangerousGoods {
        System.out.println("Welcome!");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        Scanner scan = new Scanner(System.in);


        Railway railway = new Railway(0, 10);


        Thread departure = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(5000);
                    localDate.plusDays(1);
                    System.out.println(localDate);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        departure.start();


        Sender sender1 = new Sender("John", "Seasame 1", "02345678999");
        senders.add(sender1);
        Sender sender2 = new Sender("Jacques", "Seasame 2", "02345678888");
        senders.add(sender2);


        Warehouse warehouse = new Warehouse("Main", 2);
        warehouseMap.put(warehouse, new ArrayList<>());


        Ship ship1 = new Ship("DD", "Warsaw", 4, 3,                1, 5, 6500);
        shipMap.put(ship1, new ArrayList<>());
        ships.add(ship1);

        Ship ship2 = new Ship("EefF","Paris", 2,
                4, 2, 4, 8000);
        shipMap.put(ship2, new ArrayList<>());
        ships.add(ship2);

        Ship ship3 = new Ship("Ee", "Paris",2,
                4, 2, 4, 8000);
        shipMap.put(ship3, new ArrayList<>());
        ships.add(ship3);

        Ship ship4 = new Ship( "eeee", "Paris", 2,
                4, 2, 4, 8000);
        shipMap.put(ship4, new ArrayList<>());
        ships.add(ship4);

        Ship ship5 = new Ship("bdtbrta", "Eeee", 2,
                4, 2, 4, 8000);
        shipMap.put(ship5, new ArrayList<>());
        ships.add(ship5);



        Container sc = new StandardContainer(sender1, 344, 333);
        warehouseMap.get(warehouse).add(sc);

        Container hc = new HeavyContainer(sender2, 345, 3333);
        warehouseMap.get(warehouse).add(hc);

        Container rc = new RefrigeratedContainer(sender1, 346, 2345);
        warehouseMap.get(warehouse).add(rc);

        Container lc = new LiquidContainer(sender1, 4002, 323);
        warehouseMap.get(warehouse).add(lc);

        Container tlc = new ToxicLiquidContainer(sender1, 3214, 232);
        warehouseMap.get(warehouse).add(tlc);

        Container tpc = new ToxicPowderyContainer(sender2, 323, 5455);
        warehouseMap.get(warehouse).add(tpc);



        System.out.println(warehouseMap);

        do
        {
            IO.iO();

            switch (scan.nextInt()) {
                case 0 -> {
                    scan.close();
                    System.out.println("The program has finished.");
                    System.exit(0);
                }
                case 1 -> {
                    System.out.println("Enter name: ");
                    String name = scan.next();
                    System.out.println("Enter home port: ");
                    String homePort = scan.next();
                    System.out.println("Enter maximum number of toxic explosive containers: ");
                    int maxNumToxicExplosiveContainers = scan.nextInt();
                    System.out.println("Enter maximum number of heavy containers: ");
                    int maxNumHeavyContainers = scan.nextInt();
                    System.out.println("Enter maximum number of containers with a network connection: ");
                    int maxNumNetworkConnectedContainers = scan.nextInt();
                    System.out.println("Enter maximum number of all containers: ");
                    int maxNumAllContainers = scan.nextInt();
                    System.out.println("Enter max weight load: ");
                    int maxWeightLoad = scan.nextInt();

                    Ship ship = new Ship(name, homePort, maxNumToxicExplosiveContainers, maxNumHeavyContainers,
                            maxNumNetworkConnectedContainers, maxNumAllContainers, maxWeightLoad);

                    ships.add(ship);
                    shipMap.put(ship, new ArrayList<>());

                    System.out.println("Ship created: " + shipMap);
                }
                case 2 -> {
                    System.out.println("You are creating a new container...");
                    System.out.println("Enter type of this new container:");
                    String type = scan.next();

                    System.out.println("Enter sender's id (0 or 1): ");
                    System.out.println(senders);
                    int senderId = scan.nextInt();
                    Sender sender = senders.get(senderId);

                    System.out.println("Enter tare: ");
                    int tare = scan.nextInt();

                    System.out.println("Enter net weight: ");
                    int netWeight = scan.nextInt();

                    Container container = null;

                    switch (type) {
                        case "Standard" -> container = new StandardContainer(sender, tare, netWeight);
                        case "Heavy" -> container = new HeavyContainer(sender, tare, netWeight);
                        case "Liquid" -> container = new LiquidContainer(sender, tare, netWeight);
                        case "Refrigerated" -> container = new RefrigeratedContainer(sender, tare, netWeight);
                        case "ToxicLiquid" -> container = new ToxicLiquidContainer(sender, tare, netWeight);
                        case "ToxicPowdery" -> container = new ToxicPowderyContainer(sender, tare, netWeight);
                    }

                    warehouseMap.get(warehouse).add(container);
                    System.out.println("Container created: " + container.toString());
                }
                case 3 -> {
                    System.out.println("Choose a container(id): ");
                    System.out.println(warehouseMap.get(warehouse));
                    int containerId = scan.nextInt();
                    Container container = warehouseMap.get(warehouse).get(containerId);

                    System.out.println("Which ship do you choose(id)?");
                    System.out.println(shipMap);
                    String shipScan = scan.next();
                 //   Ship ship = shipMap.get(shipScan).;

                    try {
                        ship1.loadContainer(container);
                    } catch (CapacityException e) {
                        e.printStackTrace();
                    }
                }
                case 4 -> {
                    System.out.println("Choose a container(id):");
                    scan.nextInt();

                }
                case 5 -> {
                    System.out.println("Choose a container(id): ");
                    System.out.println(warehouseMap.get(warehouse));
                    int containerId = scan.nextInt();
                    Container container = warehouseMap.get(warehouse).get(containerId);

                    try {
                        ship1.unloadContainer(container);
                    } catch (ContainerUnavailableException e) {
                        e.printStackTrace();
                    }
                }
                case 6 -> {
                    for (Map.Entry<Warehouse, List<Container>> entry : warehouseMap.entrySet()){
                        if (entry.getValue().isEmpty())
                            System.out.println(entry.getKey() + " ---- no containers");
                        else
                            System.out.println(entry.getKey() + " ---- " + entry.getValue().toString().replaceAll("[\\[\\]]", ""));
                    }
                }
                case 7 -> {
                    for (Map.Entry<Ship, List<Container>> entry : shipMap.entrySet()){
                        if (entry.getValue().isEmpty())
                            System.out.println(entry.getKey() + " ---- no containers");
                        else
                            System.out.println(entry.getKey() + " ---- " + entry.getValue().toString() + "\n");
                    }
                }
                case 8 -> {
                    IO.saveFile();
                }
                case 9 -> {

                }
            }
        } while (true);


    }
}
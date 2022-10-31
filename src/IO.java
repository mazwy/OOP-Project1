import containers.*;

import java.io.*;
import java.util.*;

public class IO {
    public static void iO() {
        System.out.println(
                """
                Enter a number to:
                (1) Create a new ship
                (2) Create a new container
                (3) Load a container onto a ship
                (4) Unload a container from a ship onto a railway
                (5) Unload a container from a ship into a warehouse
                (6) Show information about the warehouse
                (7) Show information about ships
                (8) Save to a file -> saves empty file
                (0) Exit
                """
        );
    }

    public static void saveFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logs.txt"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return;
        }

        System.out.println("File saved.");
    }

    public static void readFile() throws IOException {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("logs.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


      //  String date = bufferedReader.readLine();



}

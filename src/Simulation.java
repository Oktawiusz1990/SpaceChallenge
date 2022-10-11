import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    // Method loadItems read text line and create an Item object and then add it to ArrayList.

    ArrayList<Item> loadItems(String fileLoad) throws FileNotFoundException {
        ArrayList<Item> itemsList = new ArrayList<>();
        File file = new File(fileLoad);
        Scanner fileScanner = new Scanner(file);
        String[] itemsTable;

        while (fileScanner.hasNextLine()) {
            itemsTable = fileScanner.nextLine().split("=");
            Item item = new Item(itemsTable[0], Integer.parseInt(itemsTable[1]));
            itemsList.add(item);
        }
        return itemsList;
    }
    /*Method loadU1 takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
    It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
    and filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets
    that are fully loaded.*/

    ArrayList<Rocket> loadU1(ArrayList<Item> itemsList) {
        ArrayList<Rocket> listU1 = new ArrayList<>();
        Rocket rocketU1 = new U1();

        for (Item item : itemsList) {
            if (rocketU1.canCarry(item)) {
                rocketU1.carry(item);
            } else {
                listU1.add(rocketU1);
                rocketU1 = new U1();
            }
        }
        return listU1;
    }
    /*Method loadU2 takes the ArrayList of Items returned from loadItems and starts creating U2 rockets.
    It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
    and filling that one until all items are loaded. The method then returns the ArrayList of those U2 rockets
    that are fully loaded.*/

    ArrayList<Rocket> loadU2(ArrayList<Item> itemsList) {
        ArrayList<Rocket> listU2 = new ArrayList<>();
        Rocket rocketU2 = new U2();

        for (Item item : itemsList) {
            if (rocketU2.canCarry(item)) {
                rocketU2.carry(item);
            } else {
                listU2.add(rocketU2);
                rocketU2 = new U2();
            }
        }
        return listU2;
    }

    /*runSimulation method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets
     in the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false) it will have
     to send that rocket again. All while keeping track of the total budget required to send each rocket safely to Mars.
     runSimulation then returns the total budget required to send all rockets (including the crashed ones)..*/

    double runSimulation(ArrayList<Rocket> listOfRockets) {
        int totalCost = 0;

        for (Rocket rocket : listOfRockets) {
            totalCost = totalCost + rocket.cost;

            while (!rocket.launch() || !rocket.land()) {
                totalCost = totalCost + rocket.cost;
            }
        }
        return totalCost;
    }
}
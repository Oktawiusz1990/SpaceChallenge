import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation simulation = new Simulation();

        ArrayList<Item> phase1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> phase2 = simulation.loadItems("phase-2.txt");

        ArrayList<Rocket> u1Phase1 = simulation.loadU1(phase1);
        ArrayList<Rocket> u1Phase2 = simulation.loadU1(phase2);

        ArrayList<Rocket> u2Phase1 = simulation.loadU2(phase1);
        ArrayList<Rocket> u2Phase2 = simulation.loadU2(phase2);

        int costU1phase1 = (int) simulation.runSimulation(u1Phase1);
        int costU1phase2 = (int) simulation.runSimulation(u1Phase2);
        int costU2phase1 = (int) simulation.runSimulation(u2Phase1);
        int costU2phase2 = (int) simulation.runSimulation(u2Phase2);

        System.out.println("-------RUNNING THE SIMULATION-------");
        System.out.println();
        System.out.println("U1 cost: 100");
        System.out.println("Phase 1: " + costU1phase1);
        System.out.println("Phase 2: " + costU1phase2);
        System.out.println("Total: " + (costU1phase1 + costU1phase2));
        System.out.println();

        System.out.println("U2 cost: 120");
        System.out.println("Phase 1: " + costU2phase1);
        System.out.println("Phase 2: " + costU2phase2);
        System.out.println("Total: " + (costU2phase1 + costU2phase2));
    }
}

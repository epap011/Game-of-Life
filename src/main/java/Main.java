import com.freespirit.model.Universe;

public class Main {

    public static void main(String[] args) {
        Universe universe = new Universe(8,10);

        universe.resurrectAt(0,1);
        universe.resurrectAt(1,2);
        universe.resurrectAt(2,0);
        universe.resurrectAt(2,1);
        universe.resurrectAt(2,2);
        universe.printCurrentGeneration();

        universe.computeNextGeneration();
        universe.printCurrentGeneration();

        universe.computeNextGeneration();
        universe.printCurrentGeneration();

        universe.computeNextGeneration();
        universe.printCurrentGeneration();

        universe.computeNextGeneration();
        universe.printCurrentGeneration();
    }
}
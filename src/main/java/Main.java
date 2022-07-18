import com.freespirit.model.Universe;

public class Main {

    public static void main(String[] args) {
        Universe universe = new Universe(8,10);

        universe.bornAt(0,1);
        universe.bornAt(1,2);
        universe.bornAt(2,0);
        universe.bornAt(2,1);
        universe.bornAt(2,2);
        universe.printCurrentGeneration();

        for (int i = 0; i < 23; i++) {
            universe.computeNextGeneration();
            universe.printCurrentGeneration();
        }
    }
}
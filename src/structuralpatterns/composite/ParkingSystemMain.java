package structuralpatterns.composite;


import java.util.ArrayList;
import java.util.List;

// Component - Common Interface
interface ParkingComponent {
    void showDetails();
}

// Leaf - Represents a single Parking Spot
class ParkingSpot implements ParkingComponent {
    private int spotNumber;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    @Override
    public void showDetails() {
        System.out.println("Parking Spot #" + spotNumber);
    }
}

// Composite - Represents a Parking Lot that can hold Parking Spots or other Parking Lots
class ParkingLot implements ParkingComponent {
    private String name;
    private List<ParkingComponent> components = new ArrayList<>();

    public ParkingLot(String name) {
        this.name = name;
    }

    public void addComponent(ParkingComponent component) {
        components.add(component);
    }

    public void removeComponent(ParkingComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Parking Lot: " + name);
        for (ParkingComponent component : components) {
            component.showDetails();
        }
    }
}

// Client - Demonstrating the Composite Pattern
public class ParkingSystemMain {
    public static void main(String[] args) {
        // Create individual parking spots
        ParkingSpot spot1 = new ParkingSpot(101);
        ParkingSpot spot2 = new ParkingSpot(102);
        ParkingSpot spot3 = new ParkingSpot(103);

        // Create a small parking lot and add spots
        ParkingLot smallLot = new ParkingLot("Small Lot");
        smallLot.addComponent(spot1);
        smallLot.addComponent(spot2);

        // Create a main parking lot
        ParkingLot mainLot = new ParkingLot("Main Lot");
        mainLot.addComponent(smallLot); // Adding the small lot to main lot
        mainLot.addComponent(spot3);    // Adding an individual spot

        // Show details of the entire parking structure
        mainLot.showDetails();
    }
}

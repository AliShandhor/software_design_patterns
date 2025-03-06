package creationalpatterns.prototype;

import javax.lang.model.util.Elements;

// Step 1: Create a prototype interface
interface CarPrototype{
    CarPrototype clone();
}

// Step 2: Concrete class implementing the Prototype interface

class Car implements CarPrototype{
    private String model;
    private String color;
    private int year;

    // Constructor to initlaize the car
    public Car(String model, String color, int year){
        this.model = model;
        this.color = color;
        this.year = year;
    }
    // Clone method to create a copy of the car
    @Override
    public CarPrototype clone() {
        return new Car(this.model, this.color, this.year);
    }

    // dispaly the car details
    public void showDetails(){
        System.out.println("Car Model:  " + model + ", Color: "+ color + ", Year: " + year);
    }
}

// Step 3: Client Code

public class PrototypePatternDemo  {
    public static void main(String[] args) {
        // Original Car object
        CarPrototype originalCar = new Car("Honda Civic", "Red", 2023);
        System.out.println(originalCar.getClass());
        // Cloned Original Car
        CarPrototype clonedCar = originalCar.clone();
        System.out.println("Original Car:");
        ((Car) originalCar).showDetails();

        System.out.println("\nCloned Car");
        ((Car) clonedCar).showDetails();


    }

}

package structuralpatterns.adapter;

// The target interface
interface NewSystem{
    void displayMessage(String message);
}
// The adaptee class
class OldSystem{
    public void printMessage(String message){
        System.out.println("Old message: " + message);
    }
}

// Class Adapter (composition-based not inherited base since java does not support multiple inthertaince we stuck with composition based)
class SystemAdapter implements NewSystem{
    // it contains a reference to old system
    private OldSystem oldSystem;

    public SystemAdapter(OldSystem oldSystem){
        this.oldSystem = oldSystem;
    }


    @Override
    public void displayMessage(String message) {
        oldSystem.printMessage(message);
    }
}
// client code
public class adapterMain {

    public static void main(String[] args) {
        OldSystem oldSystem = new OldSystem();
        NewSystem newSystem = new SystemAdapter(oldSystem);

        newSystem.displayMessage("Hello. World!");

    }
}

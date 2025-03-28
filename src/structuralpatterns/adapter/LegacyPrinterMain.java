package structuralpatterns.adapter;
//System Description:
//Printer Interface: The target interface with the method printMessage(String message).
//
//LegacyPrinter Class: The existing class with the method legacyPrint(String message) to print messages in an old format.
//
//PrinterAdapter Class: The adapter class that implements the Printer interface and delegates calls to legacyPrint using composition.
// Implementing adapter pattern: target interface (new), adaptee (old), adapter (bridge), client code (main)

// adaptee
class LegacyPrinter{
    void legacyPrint(String message){
        System.out.println("legacyPrint: " + message);
    }
}
// Target
interface NewPrinter{
    void printMessage(String message);
}
// adapter
class PrinterAdapter implements NewPrinter{
    LegacyPrinter legacyPrinter;
    public PrinterAdapter(LegacyPrinter legacyPrinter){
        this.legacyPrinter = legacyPrinter;
    }


    @Override
    public void printMessage(String message) {
        legacyPrinter.legacyPrint(message);
    }
}
public class LegacyPrinterMain {
    public static void main(String[] args) {
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        NewPrinter newPrinter = new PrinterAdapter(legacyPrinter);

        String x  = "\"Hello from the new system!\"";
        newPrinter.printMessage(x);


    }


}

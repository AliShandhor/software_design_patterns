package behavioralpatterns.state;

/**
 * Demonstrates the State Pattern by switching between different mobile states.
 */
public class MobileAlertStateDemo {
    public static void main(String[] args) {
        // Create a context with the default Vibration state
        AlertStateContext stateContext = new AlertStateContext();

        // Trigger alerts in the current state (Vibration)
        stateContext.alert();
        stateContext.alert();

        // Change the state to Silent and trigger alerts
        stateContext.setState(new Silent());
        stateContext.alert();
        stateContext.alert();
        stateContext.alert();
    }
}

package behavioralpatterns.state;
// State Interface
/**
 * Represents the state of a mobile alert.
 * Defines the alert behavior that must be implemented by concrete states.
 */
interface MobileAlertState {
    /**
     * Performs an alert based on the current mobile state.
     *
     * @param ctx The context that maintains the state.
     */
    void alert(AlertStateContext ctx);
}

// Context Class
/**
 * Maintains the current state of the mobile and delegates behavior to it.
 */
class AlertStateContext {
    private MobileAlertState currentState;

    /**
     * Initializes the context with a default state (Vibration).
     */
    public AlertStateContext() {
        currentState = new Vibration(); // Default state
    }

    /**
     * Sets a new state for the mobile.
     *
     * @param state The new alert state.
     */
    public void setState(MobileAlertState state) {
        currentState = state;
    }

    /**
     * Triggers an alert, delegating to the current state.
     */
    public void alert() {
        currentState.alert(this);
    }
}

// Concrete State: Vibration
/**
 * Represents the Vibration alert state of the mobile.
 */
class Vibration implements MobileAlertState {
    /**
     * Implements the alert behavior for Vibration mode.
     *
     * @param ctx The context that maintains the state.
     */
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("Vibration mode...");
    }
}

// Concrete State: Silent
/**
 * Represents the Silent alert state of the mobile.
 */
class Silent implements MobileAlertState {
    /**
     * Implements the alert behavior for Silent mode.
     *
     * @param ctx The context that maintains the state.
     */
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("Silent mode...");
    }
}

// Demo Class

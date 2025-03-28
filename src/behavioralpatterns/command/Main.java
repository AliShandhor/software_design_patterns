package behavioralpatterns.command;

/**
 * Interface representing a command in the Command Pattern.
 * Each concrete command will implement this interface.
 */
interface ICommand {
    Result<?> doAction(); // Executes the command and returns a result.
}

/**
 * Concrete implementation of ICommand that triggers someAction1 on the Receiver.
 */
class ConcreteCommandA implements ICommand {
    private Receiver receiver; // The receiver that executes the actual logic.

    public ConcreteCommandA(Receiver receiver) {
        super();
        this.receiver = receiver;
    }

    /**
     * Executes someAction1 on the receiver and returns the result.
     */
    public Result<?> doAction() {
        return receiver.someAction1();
    }
}

/**
 * Concrete implementation of ICommand that triggers someAction2 on the Receiver.
 */
class ConcreteCommandB implements ICommand {
    private Receiver receiver; // The receiver that executes the actual logic.

    public ConcreteCommandB(Receiver receiver) {
        super();
        this.receiver = receiver;
    }

    /**
     * Executes someAction2 on the receiver and returns the result.
     */
    public Result<?> doAction() {
        return receiver.someAction2();
    }
}

/**
 * Concrete implementation of ICommand that triggers someAction3 on the Receiver.
 */
class ConcreteCommandC implements ICommand {
    private Receiver receiver; // The receiver that executes the actual logic.

    public ConcreteCommandC(Receiver receiver) {
        super();
        this.receiver = receiver;
    }

    /**
     * Executes someAction3 on the receiver and returns the result.
     */
    public Result<?> doAction() {
        return receiver.someAction3();
    }
}

/**
 * Generic Result class to encapsulate returned results.
 * @param <T> The type of data contained in the result.
 */
class Result<T> {
    private T data; // The actual result data.

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    /**
     * Retrieves the stored result data.
     */
    public T getData() {
        return data;
    }

    /**
     * Updates the stored result data.
     */
    public void setData(T data) {
        this.data = data;
    }
}

/**
 * The Receiver class contains the actual business logic that gets executed when commands are invoked.
 */
class Receiver {
    /**
     * Executes Action 1 and returns a boolean result.
     */
    public Result<Boolean> someAction1() {
        System.out.println("Some Action 1 was invoked");
        Result<Boolean> result = new Result<>();
        result.setData(true);
        return result;
    }

    /**
     * Executes Action 2 and returns a string result.
     */
    public Result<String> someAction2() {
        System.out.println("Some Action 2 was invoked");
        Result<String> result = new Result<>();
        result.setData("A String Result");
        return result;
    }

    /**
     * Executes Action 3 and returns a float result.
     */
    public Result<Float> someAction3() {
        System.out.println("Some Action 3 was invoked");
        Result<Float> result = new Result<>();
        result.setData(10.0f);
        return result;
    }
}

/**
 * The Invoker class, which stores a command and calls its execution.
 */
class Invoker {
    private ICommand command;

    /**
     * Retrieves the currently stored command.
     */
    public ICommand getCommand() {
        return command;
    }

    /**
     * Sets a new command.
     */
    public void setCommand(ICommand command) {
        this.command = command;
    }

    /**
     * Executes the stored command and returns the result.
     */
    public Result<?> execute() {
        return command.doAction();
    }
}

/**
 * Main class demonstrating the Command Pattern.
 */
public class Main {
    public static void main(String[] args) {
        Receiver receiver = new Receiver(); // The receiver that executes actual operations.

        // Creating different command objects and associating them with the receiver.
        ICommand commandA = new ConcreteCommandA(receiver);
        ICommand commandB = new ConcreteCommandB(receiver);
        ICommand commandC = new ConcreteCommandC(receiver);

        // Executing commands and printing the results.
        System.out.println(commandA.doAction().getData());
        System.out.println(commandB.doAction().getData());
        System.out.println(commandC.doAction().getData());
    }
}

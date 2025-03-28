package behavioralpatterns.strategy;

import java.util.Arrays;
import java.util.Collections;

// "Context"
 class Context {
    private Strategy strategy;
    private Integer[] array = new Integer[]{5, 4, 9, 1, 8, 3, 2, 7, 0, 6};

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Integer[] getArray() {
        return array;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.doAlgorithm(this);
    }
}

// "Strategy"
abstract class Strategy {
    public abstract void doAlgorithm(Context context);
}

// "Simple Print Strategy"
class SimplePrintStrategy extends Strategy {
    @Override
    public void doAlgorithm(Context context) {
        System.out.println("Simple Print: " + Arrays.toString(context.getArray()));
    }
}

// "Increase Print Strategy"
class IncreasePrintStrategy extends Strategy {
    @Override
    public void doAlgorithm(Context context) {
        Integer[] array = context.getArray().clone(); // Clone to avoid modifying original array
        Arrays.sort(array);
        System.out.println("Increase Print: " + Arrays.toString(array));
    }
}

// "Decrease Print Strategy"
class DecreasePrintStrategy extends Strategy {
    @Override
    public void doAlgorithm(Context context) {
        Integer[] array = context.getArray().clone(); // Clone to avoid modifying original array
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("Decrease Print: " + Arrays.toString(array));
    }
}

// Client Code
public class StrategyMain {
    public static void main(String[] args) {
        // Create a context with simple printing strategy
        Context context = new Context(new SimplePrintStrategy());
        context.execute();
        System.out.println("***********************");

        // Change the strategy to increasing
        context.setStrategy(new IncreasePrintStrategy());
        context.execute();
        System.out.println("***********************");

        // Change the strategy to decreasing
        context.setStrategy(new DecreasePrintStrategy());
        context.execute();
        System.out.println("***********************");
    }
}
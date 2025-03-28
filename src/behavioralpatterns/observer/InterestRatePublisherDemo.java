package behavioralpatterns.observer;

import java.util.ArrayList;
import java.util.List;

 abstract class Observer{
    abstract void update();
}

// concrete observer
class MortgageLoadRateCalculator extends Observer{
    private InterestRatePublisher interestRatePublisher;
    public MortgageLoadRateCalculator(InterestRatePublisher interestRatePublisher){
        this.interestRatePublisher = interestRatePublisher;
    }
    @Override
    public void update() {
        double interestRate = this.interestRatePublisher.getInterestRate() * 1.5;
        System.out.println("Mortgage rate: " + interestRate);
    }
}

class OvernightLoadRateCalculator extends Observer{
    private InterestRatePublisher interestRatePublisher;
    public OvernightLoadRateCalculator(InterestRatePublisher interestRatePublisher){
        this.interestRatePublisher = interestRatePublisher;
    }
    @Override
    public void update() {
        double interestRate = this.interestRatePublisher.getInterestRate() * 1.1;
        System.out.println("Overnight rate: " + interestRate);
    }
}

class AutoLoadRateCalculator extends Observer{
    private InterestRatePublisher interestRatePublisher;
    public AutoLoadRateCalculator(InterestRatePublisher interestRatePublisher){
        this.interestRatePublisher = interestRatePublisher;
    }
    @Override
    public void update() {
        double interestRate = this.interestRatePublisher.getInterestRate() * 2.0;
        System.out.println("Auto rate: " + interestRate);
    }
}
// Publisher or subject
class InterestRatePublisher {
    private List<Observer> observers = new ArrayList<>();
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
        notifyAllObservers();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    // notify method
    public void notifyAllObservers(){
        for (Observer observer : observers){
            observer.update();
        }

    }
}

public class InterestRatePublisherDemo {
    public static void main(String[] args) {
        InterestRatePublisher interestRatePublisher = new InterestRatePublisher();
        Observer observer1 = new MortgageLoadRateCalculator(interestRatePublisher);
        Observer observer2 = new AutoLoadRateCalculator(interestRatePublisher);
        Observer observer3 = new OvernightLoadRateCalculator(interestRatePublisher);

        interestRatePublisher.addObserver(observer1);
        interestRatePublisher.addObserver(observer2);
        interestRatePublisher.addObserver(observer3);

        interestRatePublisher.setInterestRate(1.25);
    }
}
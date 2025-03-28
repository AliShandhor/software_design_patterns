package behavioralpatterns.observer;
//Scenario:
//A WeatherStation (Subject) notifies multiple Displays (Observers) when the temperature changes.

import java.util.ArrayList;
import java.util.List;
// one to many dependency relationship; one object (the Subject) changes state, all dependent objects (the Observers) are automatically notified and updated.
// subject (publisher) and observers (subscribers i.e. users)

// Observer interface
interface WeatherObserver{
    void update(float temp);
}

// subject (publisher or obserable)
class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private float temp;

        public void addObserver(WeatherObserver weatherObserver){
            observers.add(weatherObserver);
        }

        public void removeObserver(WeatherObserver weatherObserver){
            observers.remove(weatherObserver);
        }

        public void setTemp(float temp){
            this.temp = temp;
            notifyObservers();
        }
        public void notifyObservers(){
            for (WeatherObserver observer: observers){
                observer.update(temp);
            }
        }
}

// concrete observer
class DisplayScreen implements WeatherObserver{
    private String name;
    public DisplayScreen(String name){
        this.name = name;
    }
    @Override
    public void update(float temp) {
        System.out.println(name + " Updated: Temperature is now '" + temp +"°C");

    }
}

public class WeatherStationMain {
    // subject

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        WeatherObserver observer1 = new DisplayScreen("Ali Shandhor");
        WeatherObserver observer2 = new DisplayScreen("John Doe");

        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);

        System.out.println("Setting temperature to 25°C");
        weatherStation.setTemp(25);

        System.out.println("Setting temperature to 30°C");
        weatherStation.setTemp(30);


    }

}

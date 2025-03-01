package creationalpatterns.singleton;


// singleton object User
public class Main {

    public static void main(String[] args) {

        // SingletonObject Class Example
        System.out.println("====SingletonObject Class Example=====");
        SingletonObject singletonInstance = SingletonObject.getSingletonInstance();
        int data = singletonInstance.getSingletonData();
        System.out.println("Data: " + data);

        //RandomObject
        System.out.println("====RandomGenerator====");
        RandomGenerator randomGeneratorInstance = RandomGenerator.getRandomGeneratorInstance();
        int randomValue = randomGeneratorInstance.generateRandomNumbers();
        System.out.println("Random value is: " + randomValue);

    }
}


package creationalpatterns.singleton;
    // The RandomGenerator class demonestartes the Singleton pattern with lazy initialization
    // and thread safety. It ensures a single instance is created, even in multi-threaded environments,
    // using double-checked locking. The getRandomGeneratorInstance() method creates the instance 
    // only when needed. The generateRandomNumbers() method generates a random number between 0 and 99.
    // The private constructor prevents external instantiation, enforcing the Singleton pattern.   

import java.util.Random;
// We follow rules of singleton pattern rules - mentioned in SingletonObject.java + adding lazy initliazation to provide creating multiple objects for multithreading scenarios
public class RandomGenerator {
    private static  RandomGenerator randomGeneratorInstance;
    // Private constructor prevents external instantiation
    private RandomGenerator(){};

    public static RandomGenerator getRandomGeneratorInstance(){
        // Ensures ONLY one instance will only be initialized
        if (randomGeneratorInstance == null){
            // Lazy initialization for multi-threading purpose
            synchronized (RandomGenerator.class){
                if (randomGeneratorInstance == null) {
                    randomGeneratorInstance = new RandomGenerator();
                    return randomGeneratorInstance;
                }
            }
        }
        return randomGeneratorInstance;
    }


    public int generateRandomNumbers(){
        System.out.println("Random Generator starts working...");
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(100);
    }



}

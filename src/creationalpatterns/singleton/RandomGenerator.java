package creationalpatterns.singleton;
import java.util.Random;

// We follow rules of singleton pattern rules + adding lazy initliazation to provide creating multiple objects for multithreading scenarios
public class RandomGenerator {
    private static  RandomGenerator randomGeneratorInstance;

    private RandomGenerator(){};

    public static RandomGenerator getRandomGeneratorInstance(){
        if (randomGeneratorInstance == null){
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
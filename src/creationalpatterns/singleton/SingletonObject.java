package creationalpatterns.singleton;
// 3 things you need to have in order to apply this singleton pattern
// 1. Make the constructor private to prevent clients/others from initializing it from outside the class
// 2. Declare private static instance of singleton object
// 3. Write a public static gettor method to get the singleton instance.
public class SingletonObject {

    // To use singleton design pattern (creational), create only one private static variable.
    private static final SingletonObject singletonInstance = new SingletonObject();

    // prevent the other classes accessing this singleton class by making the constructor as private
    private SingletonObject(){}

    // create a public static method to return and get the only class object
    public static SingletonObject getSingletonInstance(){
//        if (singletonInstance == null) {
//            singletonInstance = new SingletonObject();
//        }
        return singletonInstance;
    }

    // to access the other methods of class after getting the only singleton instance
    public int getSingletonData(){
        System.out.println("Singleton Object is set to be used ");
        return 1;
    }

}

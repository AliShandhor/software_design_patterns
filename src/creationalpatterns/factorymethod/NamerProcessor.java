package creationalpatterns.factorymethod;
// Factory Pattern: aAllows a class to defer its instantiation to its subclasses.

/// Example 1:
/// A simple example of using a Factory class to handle different formats for user input.
/// Suppose we have an entry form where users can input their name in one of two formats:
/// - "firstname lastname"
/// - "lastname, firstname" (with a comma separating the last name and first name)
/// A Factory class can instantiate objects responsible for parsing names based on the input format.
/// It encapsulates the logic for determining the format and returns the appropriate object or method
/// to handle the parsing accordingly. This approach enhances flexibility and ensures that
/// the logic for each format remains isolated and easier to maintain.
///  Note that subclasses objects are objects/instance of superclasses.


// Superclass/Base class
class Namer {
    String first;
    String last;

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
    public void displayFullName() {
        System.out.println(first + " " + last);
    }
}
// First Subclass
class FirstFirst extends Namer{
    FirstFirst(String full_name){
        int i = full_name.indexOf(" ");

        if (i > 0){
            first = full_name.substring(0, i).trim();
            last = full_name.substring(i).trim();
        }

        else{
            first = "";
            last = full_name;
        }
    }
}

// Second Subclass
class LastFirst extends Namer{
    LastFirst(String fullName){
        // specify index where the comma is found
        int i = fullName.lastIndexOf(',');
        if (i > 0){

            last = fullName.substring(0, i).trim();
            first = fullName.substring(i + 1).trim();
        }
        else{
            last = "";
            first = fullName;
        }
    }
}

// Factory Pattern
class NameFactory{
    // No customized Factory constructor

    // we create the instances/objects of Namer class in this Factory method using an argument
    public Namer getNamer(String fullNameFormat){
        // check if the command found
        int i = fullNameFormat.indexOf(',');

        if (i > 0){
            return new LastFirst(fullNameFormat);
        }
        else{
            return new FirstFirst(fullNameFormat);
        }
    }
}

public class NamerProcessor {
    // Using the Factory
    public static void main(String[] args) {
        String fullNameFormat = "Shandhor,Ali";
        NameFactory nameFactory = new NameFactory();

        Namer nameObject = nameFactory.getNamer(fullNameFormat);

        System.out.println(nameObject.getFirst());
        System.out.println(nameObject.getLast());

        nameObject.displayFullName();
    }
}

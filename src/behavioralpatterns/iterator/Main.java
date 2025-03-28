package behavioralpatterns.iterator;

// Step 1: Create an Iterator Interface
interface MyIterator {
    boolean hasNext();
    String next();
}

// Step 2: Create a Concrete Iterator
class NameIterator implements MyIterator {
    private String[] names;
    private int index = 0;

    public NameIterator(String[] names) {
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        return index < names.length;
    }

    @Override
    public String next() {
        return hasNext() ? names[index++] : null;
    }
}

// Step 3: Create a Collection Class
class NameCollection {
    private String[] names = {"Ali", "Uzma", "Ainaz"};

    public MyIterator getIterator() {
        return new NameIterator(names);
    }
}

// Step 4: Test the Iterator Pattern
public class Main {
    public static void main(String[] args) {
        NameCollection collection = new NameCollection();
        MyIterator iterator = collection.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

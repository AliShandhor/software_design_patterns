package creationalpatterns.abstractfactory;

/**
 * System Description:
 *
 * In this pattern, an interface is responsible for creating a factory of relevant objects
 * without explicitly specifying their concrete implementations, i.e., classes. Each
 * generated factory can produce the classes using the factory method pattern.
 *
 * Suppose, we have both custom and native themes for our operating system. However,
 * at any given time, we want to use one of the themes, and while doing that, we do not
 * want to keep track of each concrete implementation of the themes. In addition,
 * it may happen that the custom and native themes may be implemented by different
 * classes and can be accessed via different access points (e.g., factory methods).
 *
 * Steps to Implement the Abstract Factory Pattern:
 *
 * 1️⃣ Create a common interface (Theme) for all products.
 * 2️⃣ Implement concrete classes (CustomLight, CustomDark, NativeLight, NativeDark) that follow the interface.
 * 3️⃣ Define an abstract factory (AbstractThemeFactory) to enforce the creation method.
 * 4️⃣ Implement concrete factories (CustomThemeFactory, NativeThemeFactory) that extend the abstract factory.
 * 5️⃣ Create a **Super Factory** (Factory of Factories) called ThemeProducer to return the appropriate sub-factory.
 * 6️⃣ Use the factories in the main method to create and display themes dynamically.
 */

// Step 1: Define a common interface
interface Theme {
    public void show();  // Method to display the theme
}

// Step 2: Implement concrete classes for each theme
class CustomLight implements Theme {
    @Override
    public void show() {
        System.out.println("Showing Custom Light Theme");
    }
}

class CustomDark implements Theme {
    @Override
    public void show() {
        System.out.println("Showing Custom Dark Theme");
    }
}

class NativeLight implements Theme {
    @Override
    public void show() {
        System.out.println("Showing Native Light Theme");
    }
}

class NativeDark implements Theme {
    @Override
    public void show() {
        System.out.println("Showing Native Dark Theme");
    }
}

// Step 3: Create an abstract factory class
abstract class AbstractThemeFactory {
    public abstract Theme getTheme(String themeType); // Method to get the theme object
}

// Step 4: Implement concrete factories (Sub Factories)
class CustomThemeFactory extends AbstractThemeFactory {
    @Override
    public Theme getTheme(String themeType) {
        if (themeType.equalsIgnoreCase("LIGHT")) {
            return new CustomLight();
        } else if (themeType.equalsIgnoreCase("DARK")) {
            return new CustomDark();
        }
        return null;
    }
}

class NativeThemeFactory extends AbstractThemeFactory {
    @Override
    public Theme getTheme(String themeType) {
        if (themeType.equalsIgnoreCase("LIGHT")) {
            return new NativeLight();
        } else if (themeType.equalsIgnoreCase("DARK")) {
            return new NativeDark();
        }
        return null;
    }
}

// Step 5: Create a Super Factory (Factory of Factories)
/**
 * Super Factory (Factory of Factories): ThemeProducer returns a 'Factory' either CustomThemeFactory or NativeThemeFactory.
 * Instead of directly creating Theme objects, it provides and returns the appropriate 'Factory' based on input.
 */
class ThemeProducer {
    public static AbstractThemeFactory getFactory(boolean isNative) {
        if (isNative) {
            return new NativeThemeFactory(); // Returns Native Theme Factory
        } else {
            return new CustomThemeFactory(); // Returns Custom Theme Factory
        }
    }
}

// Step 6: Use the factory in main
public class ThemeProducerMain {
    public static void main(String[] args) {
        // Get Custom Theme Factory
        AbstractThemeFactory themeFactory1 = ThemeProducer.getFactory(false);
        Theme light = themeFactory1.getTheme("LIGHT");
        light.show(); // Output: Showing Custom Light Theme

        // Get Native Theme Factory
        AbstractThemeFactory themeFactory2 = ThemeProducer.getFactory(true);
        Theme dark = themeFactory2.getTheme("DARK");
        dark.show(); // Output: Showing Native Dark Theme
    }
}

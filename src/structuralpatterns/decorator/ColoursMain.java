package structuralpatterns.decorator;


interface Shape{
    void draw();

}

class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("This is Triangle");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("This is Circle");
    }
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("This is Rectangle");
    }
}

// decorat abstract class
abstract class FillDecorator implements Shape{
    protected Shape shape;

    public FillDecorator(Shape shape){
        this.shape = shape;
    }
    @Override
    public void draw() {
        shape.draw();
    }

}

class Fill extends FillDecorator{
    String colour;
    public Fill(Shape shape, String color) {
        super(shape);
        this.colour = color;
    }

    @Override
    public void draw() {
        shape.draw();
        fill(colour);
    }

    public void fill(String colour){
        System.out.println("filled by " + colour);
    }
}

public class ColoursMain {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        triangle.draw();

        Shape circle = new Circle();
        circle.draw();

        Shape rectangle = new Triangle();
        rectangle.draw();

        System.out.println("============Colour Filling Feature===========");
        Shape redTriangle = new Fill(new Triangle(), "Red");
        redTriangle.draw();

        Shape greenCircle = new Fill(new Circle(), "Green");
        greenCircle.draw();

        Shape blueRectangle = new Fill(new Rectangle(), "Blue");
        blueRectangle.draw();

    }
    // Original


}

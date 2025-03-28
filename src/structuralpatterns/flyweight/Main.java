package structuralpatterns.flyweight;

import java.util.HashMap;

interface Pen {
    void setColour(String colour);
    void draw(String content);
}

enum BrushSize{
    THIN, MEDIUM, THICK
}
class ThinPen implements Pen{
    final BrushSize brushSize = BrushSize.THIN;
    private String colour;

    @Override
    public void setColour(String colour) {
        this.colour =colour ;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing THIN content  '" + content+ "' in color " + colour);
    }
}

class MediumPen implements Pen{
    final BrushSize brushSize = BrushSize.MEDIUM;
    private String colour;

    @Override
    public void setColour(String colour) {
        this.colour =colour ;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing MEDIUM content  '" + content+ "' in color " + colour);
    }
}

class ThickPen implements Pen{
    final BrushSize brushSize = BrushSize.THICK;
    private String colour;

    @Override
    public void setColour(String colour) {
        this.colour =colour ;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing THICK content  '" + content + "' in color " + colour);
    }
}

class PenFactory{
    private static final HashMap<String, Pen> pensMap = new HashMap<>();

    public static Pen getPen(Enum<BrushSize> thickNess, String colour){
        String key = thickNess.toString() + "-" + colour;
        Pen pen = pensMap.get(key);
        if (pen!=null){
            return pen;
        }
        else{
            if (thickNess.toString() == "Thick"){
                pen = new ThickPen();
            }
            else if (thickNess.toString() == "MEDIUM"){
                pen = new MediumPen();
            }
            else {
                pen = new ThickPen();
            }
        }
        pen.setColour(colour);
        pensMap.put(key, pen);
        return pen;
    }

}

public class Main {
    public static void main(String[] args) {
        String content  = "Hello World";

        Pen redThinBrushOne = PenFactory.getPen(BrushSize.THIN, "RED");
        redThinBrushOne.draw(content);

        Pen redMediumBrushOne = PenFactory.getPen(BrushSize.MEDIUM, "RED");
        redMediumBrushOne.draw(content);


        Pen redThickBrushOne = PenFactory.getPen(BrushSize.THICK, "RED");
        redThickBrushOne.draw(content);

    }
}

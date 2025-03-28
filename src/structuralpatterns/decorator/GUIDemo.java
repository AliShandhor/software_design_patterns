package structuralpatterns.decorator;
//Suppose, we have two editors, one a text
//editor and another an image editor. The
//two editors at this moment do not have
//any scrolling functionality. We do not
//want to change any implementation of
//the two classes implementing the two
//editors. We thus can use the decorator
//pattern to add scrollbar feature
//dynamically to the objects of the classes
//at run time.

// component interface for product

import java.sql.SQLOutput;

interface GUI{
    void show();
}


// Concrete components
class TextEditorUI implements GUI{

    @Override
    public void show() {
        System.out.println("Text Editor UI");
    }
}

class ImageEditorUI implements GUI{

    @Override
    public void show() {
        System.out.println("ImageEditionUI");
    }
}

// Decorator
abstract class ViewDecorator implements GUI {
    protected GUI decoratedUI;

    public ViewDecorator(GUI gui){
        this.decoratedUI = gui;
    }
    @Override
    public void show() {
        decoratedUI.show();
    }

}



// concrete decorator
class  EditorViewDecorator extends ViewDecorator{

    public EditorViewDecorator(GUI gui) {
        super(gui);
    }

    @Override
    public void show() {
        decoratedUI.show();
        setScrollbar();
    }
    public void setScrollbar(){
        System.out.println("Showing scrollbar");
    }}

public class GUIDemo {
    public static void main(String[] args) {
        GUI imageEditor = new ImageEditorUI();
        imageEditor.show();

        GUI textEditor  = new TextEditorUI();
        textEditor.show();

        // scrollbar
        GUI textImagewWithScrollbar = new EditorViewDecorator(new ImageEditorUI());
        textImagewWithScrollbar.show();
        // scrollbar
        GUI TextithScrollbar = new EditorViewDecorator(new TextEditorUI());
        TextithScrollbar.show();

    }

}

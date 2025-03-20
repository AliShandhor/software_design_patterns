package structuralpatterns.composite;

// Imagine a file system where files and folders follow a hierarchical structure:
//
//        A File is a Leaf because it cannot contain other files or folders.
//        A Folder is a Composite because it can contain multiple files or subfolders.

// component, leaf, composite, client

import java.util.ArrayList;

// component interface
interface FileSystemComponent{
    void shotDetails();
}

// leaf class (primitive object)
class File implements FileSystemComponent{
    private String name;
    public File(String name){
        this.name = name;
    }

    @Override
    public void shotDetails() {
        System.out.println("File: " + name);
    }

}
// Composite class (Folder)
class Folder implements FileSystemComponent{
    private String name;
    private ArrayList<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void add(FileSystemComponent component){
        children.add(component);
    }


    @Override
    public void shotDetails() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : children){
            component.shotDetails();
        }

    }
}
// Client Code
public class FileSystemMain {
    public static void main(String[] args) {
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");

        Folder folder = new Folder("txt-file-container");
        folder.add(file1);
        folder.add(file2);

        folder.shotDetails();

    }
}

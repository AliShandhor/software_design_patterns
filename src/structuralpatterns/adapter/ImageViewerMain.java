package structuralpatterns.adapter;
// Suppose, we have developed a trivial image viewer that can process on JPG and JPEG file
//types. We have access to two software; one can process PNG (GIMP) and another can
//process SVG (Adobe SVG Viewer). We would like to extend our trivial image viewer to also
//support the PNG and SVG file types. However, we do not want to rewrite the code, rather
//we want to create an adapter pattern to include GIMP and Adobe class features into our
//image viewer.
// new interfacc

import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;

// old
interface AdvancedImageViewer{
    void showPNG(String fileName);
    void showSVG(String fileName);
}

class PNG implements AdvancedImageViewer{

    @Override
    public void showPNG(String fileName) {
        System.out.println("Showing PNG: " + fileName);
    }

    @Override
    public void showSVG(String fileName) {
        // nothing
    }
}

class SVG implements AdvancedImageViewer{
    @Override
    public void showPNG(String fileName) {

    }

    @Override
    public void showSVG(String fileName) {
        System.out.println("Showing SVG: " + fileName);
    }
}

// new one supporting JPG and JPEG
interface ImageViewer{
    void show(String fileType, String fileName);
}

class TrivialImageViewer implements ImageViewer{
    private ImageViewerAdapter imageViewerAdapter;

    @Override
    public void show(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("JPG") || fileType.equalsIgnoreCase("JPEG")){
            System.out.println("Showing " + fileType + ": " + fileName);
        }
        // we want to use the legacy system here
        else if(fileType.equalsIgnoreCase("SVG") || fileType.equalsIgnoreCase("PNG")){
            imageViewerAdapter = new ImageViewerAdapter(fileType);
            imageViewerAdapter.show(fileType, fileName);
        }
        else {
            throw new IllegalArgumentException("Invalid File!");
        }
    }
}

class ImageViewerAdapter implements ImageViewer{
        // old
    private AdvancedImageViewer advancedImageViewer;

    public ImageViewerAdapter(String fileType){
        if (fileType.equalsIgnoreCase("PNG")) {
            advancedImageViewer = new PNG();
        } else if (fileType.equalsIgnoreCase("SVG")) {
            advancedImageViewer = new SVG();

        }
        else {
            advancedImageViewer = null;
        }
    }
    @Override
    public void show(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("PNG")) {
            advancedImageViewer.showPNG(fileName);
        } else if (fileType.equalsIgnoreCase("SVG")) {
            advancedImageViewer.showSVG(fileName);
        }
    }
}


public class ImageViewerMain {
    public static void main(String[] args) {
        TrivialImageViewer trivialImageViewer = new TrivialImageViewer();
        trivialImageViewer.show("JPG", "file1");

        trivialImageViewer.show("SVG", "file2");
    }
}
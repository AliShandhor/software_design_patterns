package na;

public class Book {
    String isbn;
    String title;
    String author;

    Book(String isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }
}

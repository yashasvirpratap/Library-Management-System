package librarysystem;

public class BookFactory {
    public static IBook createBook(String title, String author, String ISBN, int year) {
        return new Book(title, author, ISBN, year);
    }
}

package librarysystem;

import java.util.List;

public interface IPatron {
    String getName();
    String getPatronId();
    List<IBook> getBorrowedBooks();
    void borrowBook(IBook book);
    void returnBook(IBook book);
}

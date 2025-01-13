package librarysystem;

import java.util.ArrayList;
import java.util.List;

public class Patron implements IPatron {
    private final String name;
    private final String patronId;
    private final List<IBook> borrowedBooks;

    public Patron(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getter methods, borrowBook, returnBook methods

    public String getName() {
        return name;
    }

    public String getPatronId() {
        return patronId;
    }

    public List<IBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(IBook book) {
        borrowedBooks.add(book);
    }

    public void returnBook(IBook book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", patronId='" + patronId + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}


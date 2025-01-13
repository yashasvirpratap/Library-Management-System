package librarysystem;

import java.util.ArrayList;
import java.util.List;

class Library {
    private static Library instance;
    private final List<IBook> books;
    private final List<IPatron> patrons;
    private SearchStrategy searchStrategy;

    private Library() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    // Book management
    public void addBook(IBook book) {
        books.add(book);
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    public void setSearchStrategy(SearchStrategy strategy) {
        this.searchStrategy = strategy;
    }

    public List<IBook> searchBooks(String query) {
        return searchStrategy.search(books, query);
    }

    // Patron management
    public void addPatron(IPatron patron) {
        patrons.add(patron);
    }

    public IPatron getPatron(String patronId) {
        return patrons.stream().filter(patron -> patron.getPatronId().equals(patronId)).findFirst().orElse(null);
    }

    // Lending process
    public void checkoutBook(String ISBN, String patronId) {
        IBook book = books.stream().filter(b -> b.getISBN().equals(ISBN) && b.getStatus() == BookStatus.AVAILABLE).findFirst().orElse(null);
        IPatron patron = getPatron(patronId);
        if (book != null && patron != null) {
            book.setStatus(BookStatus.BORROWED);
            patron.borrowBook(book);
        }
    }

    public void returnBook(String ISBN, String patronId) {
        IBook book = books.stream().filter(b -> b.getISBN().equals(ISBN) && b.getStatus() == BookStatus.BORROWED).findFirst().orElse(null);
        IPatron patron = getPatron(patronId);
        if (book != null && patron != null) {
            book.setStatus(BookStatus.AVAILABLE);
            patron.returnBook(book);
        }
    }
}


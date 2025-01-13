package librarysystem;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create instances of Library, Book, and Patron
        Library library = Library.getInstance();

        // Create books using the BookFactory
        Book book1 = (Book) BookFactory.createBook("The Great Gatsby", "F. Scott Fitzgerald", "1234567890", 1925);
        Book book2 = (Book) BookFactory.createBook("1984", "George Orwell", "9876543210", 1949);
        Book book3 = (Book) BookFactory.createBook("To Kill a Mockingbird", "Harper Lee", "1122334455", 1960);

        // Log book creation
        LoggerUtil.logInfo("Books created: 'The Great Gatsby', '1984', 'To Kill a Mockingbird'");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        LoggerUtil.logInfo("Books added to library: 'The Great Gatsby', '1984', 'To Kill a Mockingbird'");

        // Create patrons
        Patron patron1 = new Patron("Alice", "P001");
        Patron patron2 = new Patron("Bob", "P002");

        // Log patron creation
        LoggerUtil.logInfo("Patrons created: Alice (P001), Bob (P002)");

        // Add patrons to the library
        library.addPatron(patron1);
        library.addPatron(patron2);
        LoggerUtil.logInfo("Patrons added to library: Alice (P001), Bob (P002)");

        // Set a search strategy (Search by Title)
        library.setSearchStrategy(new SearchByTitle());

        // Search books by title
        List<IBook> searchResultByTitle = library.searchBooks("1984");
        LoggerUtil.logInfo("Searching for book with title '1984'");
        System.out.println("Search Results for '1984':");
        searchResultByTitle.forEach(System.out::println);

        // Checkout a book
        System.out.println("\nCheckout Book '1984' for Patron Alice");
        LoggerUtil.logInfo("Checkout Book '1984' for Patron Alice");
        library.checkoutBook("9876543210", "P001");

        // Display patron's borrowed books
        System.out.println("\nPatron Alice's Borrowed Books:");
        patron1.getBorrowedBooks().forEach(System.out::println);

        // Return the book
        System.out.println("\nReturn Book '1984' for Patron Alice");
        LoggerUtil.logInfo("Return Book '1984' for Patron Alice");
        library.returnBook("9876543210", "P001");

        // Display patron's borrowed books after return
        System.out.println("\nPatron Alice's Borrowed Books after Return:");
        if (patron1.getBorrowedBooks().isEmpty()) {
            LoggerUtil.logInfo("No books borrowed by Patron Alice.");
            System.out.println("No books borrowed.");
        } else {
            patron1.getBorrowedBooks().forEach(System.out::println);
        }


        // Checkout another book
        System.out.println("\nCheckout Book 'The Great Gatsby' for Patron Bob");
        LoggerUtil.logInfo("Checkout Book 'The Great Gatsby' for Patron Bob");
        library.checkoutBook("1234567890", "P002");

        // Display patron's borrowed books
        System.out.println("\nPatron Bob's Borrowed Books:");
        patron2.getBorrowedBooks().forEach(System.out::println);

        // Remove a book
        System.out.println("\nRemoving Book 'To Kill a Mockingbird' from library");
        LoggerUtil.logInfo("Removing Book 'To Kill a Mockingbird' from library");
        library.removeBook("1122334455");

        // Search books after removal
        List<IBook> searchResultAfterRemoval = library.searchBooks("To Kill a Mockingbird");
        LoggerUtil.logInfo("Searching for book 'To Kill a Mockingbird' after removal");
        System.out.println("\nSearch Results after removing 'To Kill a Mockingbird':");
        if (searchResultAfterRemoval.isEmpty()) {
            System.out.println("No books found.");
        } else {
            searchResultAfterRemoval.forEach(System.out::println);
        }
    }
}

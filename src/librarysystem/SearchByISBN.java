package librarysystem;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByISBN implements SearchStrategy {
    public List<IBook> search(List<IBook> books, String ISBN) {
        return books.stream().filter(book -> book.getISBN().equals(ISBN)).collect(Collectors.toList());
    }
}

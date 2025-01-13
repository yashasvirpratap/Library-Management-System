package librarysystem;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByAuthor implements SearchStrategy {
    public List<IBook> search(List<IBook> books, String author) {
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }
}

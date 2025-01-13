package librarysystem;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByTitle implements SearchStrategy {
    public List<IBook> search(List<IBook> books, String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }
}

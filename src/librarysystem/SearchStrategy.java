package librarysystem;

import java.util.List;

public interface SearchStrategy {
    List<IBook> search(List<IBook> books, String query);
}

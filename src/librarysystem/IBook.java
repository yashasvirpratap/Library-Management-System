package librarysystem;
import java.util.List;

public interface IBook {
    String getTitle();
    String getAuthor();
    String getISBN();
    int getPublicationYear();
    BookStatus getStatus();
    void setStatus(BookStatus status);
}

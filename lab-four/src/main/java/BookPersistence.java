import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@SuppressWarnings("all")
public class BookPersistence implements Persistence {

    private final Book book;

    public BookPersistence(Book book) {this.book = book;}

    @Override
    public void persist() {
        try {
            FileOutputStream fout = new FileOutputStream(book.getTitle() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

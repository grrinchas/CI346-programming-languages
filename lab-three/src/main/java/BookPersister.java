
import java.io.Serializable;
import java.util.Optional;

@SuppressWarnings("all")
public interface BookPersister extends Serializable{

    Optional<Book> read();

    void save();

}

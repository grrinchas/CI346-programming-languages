
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * CI346
 * Entry point for the Week 4 Lab Session.
 */
@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        try {
            String[] contents = readLines(Main.class.getResource("pg1459.txt").getFile());
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date dob = formatter.parse("09/26/1888");
            Author a = new Author("Thomas", "Stearns", "Eliot", dob);
            Book b = new Book("Prufrock and Other Observations", a, contents);
            Persistence persistence = new BookPersistence(b);
            persistence.persist();

            Optional<Book> anotherBook = new BookProducer(b.getTitle()+".ser").produce();
            if(anotherBook.isPresent()){
                b = anotherBook.get();
                BookFormatter bf = new BookContentsFormatter(b);
                System.out.println(bf.format());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer lines = new StringBuffer();
        List<String> pages = new ArrayList<String>();
        String line;
        int linesRead = 0;
        int linesPerPage = 50;
        while ((line = bufferedReader.readLine()) != null) {
            lines.append(line);
            lines.append("\n");
            linesRead++;
            if(linesRead >= linesPerPage) {
                pages.add(lines.toString());
                lines.delete(0, lines.length());
                linesRead = 0;
            }
        }
        if(lines.length()>0) {
            pages.add(lines.toString());
        }
        bufferedReader.close();
        return pages.toArray(new String[pages.size()]);
    }
}

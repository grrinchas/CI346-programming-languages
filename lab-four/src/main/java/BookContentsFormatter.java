@SuppressWarnings("all")
public class BookContentsFormatter extends BookFormatter {

    public BookContentsFormatter(Book book) {
        super(book);
    }

    @Override
    public String format() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < super.book.getLength(); i++) {
            sb.append("------------------------------------------------- ");
            sb.append(formatHeader());
            sb.append("------------------------------------------------- \n");
            sb.append(formatPage());
            super.book.turnPage();
        }
        return sb.toString();
    }
}

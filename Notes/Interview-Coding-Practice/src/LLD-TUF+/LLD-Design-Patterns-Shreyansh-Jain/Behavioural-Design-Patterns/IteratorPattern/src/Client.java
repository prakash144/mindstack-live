import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Book> booksList = Arrays.asList(
                new Book(100, "Science"),
                new Book(200, "Maths"),
                new Book(300, "CSE"),
                new Book(400, "Networking")
        );

        Library library = new Library(booksList);
        Iterator iterator = library.createIterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getBookName());
        }
    }
}
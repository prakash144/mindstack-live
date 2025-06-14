public class Book {

    private int price;
    private String bookName;

    Book(int price, String bookName) {
        this.bookName = bookName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPrice() {
        return price;
    }
}

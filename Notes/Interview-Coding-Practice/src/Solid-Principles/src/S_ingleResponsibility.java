/*
 * Class Relationship Diagram (Flow Chart / Mind Map)
 *
 *                              +-----------------------------------+
 *                              |     SingleResponsibility_1        |
 *                              |          (Main class)             |
 *                              +-----------------------------------+
 *                                             |
 *               +-----------------------------+-----------------------------+
 *               |                                                           |
 *               |                                                           |
 *    +--------------------------+                              +-----------------------------+
 *    |         Marker            |                              |         Invoice            |
 *    | (Holds marker data: name, |                              | (Calculates total cost for |
 *    | color, year, price)       |                              |  markers, holds marker and |
 *    +--------------------------+                               | quantity information)      |
 *               |                                                           |
 *    +----------------------+                                    +---------------------------+
 *    |   getName()           |                                    | getMarker()               |
 *    |   getColor()          |                                    | getQuantity()             |
 *    |   getYear()           |                                    | calculateTotal()          |
 *    |   getPrice()          |                                    +---------------------------+
 *    +----------------------+                                                |
 *                                      +-------------------------------------+------------------------------------+
 *                                      |                                                                          |
 *        +-------------------------+                         +-------------------------+            +--------------------------+
 *        |     InvoiceDao           |                         |   InvoicePrinter        |           |       Future Class       |
 *        |  (Saves invoice to DB)   |                         | (Prints invoice details |           | (Potential extension for |
 *        +-------------------------+                          | to the console)         |           | handling new tasks)      |
 *                |                                             +-------------------------+           +--------------------------+
 *    +----------------------------+                                     |                                       |
 *    | saveToDatabase()            |                                     |                                      |
 *    +----------------------------+                          +----------------------------+                     |
 *                                                            |       print()              |                     |
 *                                                            +----------------------------+                     |
 *                                                                                                               |
 *                                                                                                               |
 *                                                 +---------------------------------------------------------+---+
 *                                                 |
 *                                        (Returns total price for invoice based on marker quantity)
 *
 * - The `Marker` class handles marker information (name, color, year, price).
 * - The `Invoice` class calculates the total price based on the marker and its quantity.
 * - The `InvoiceDao` class is responsible for saving the invoice to a database (single responsibility for persistence).
 * - The `InvoicePrinter` class is responsible for printing the invoice details to the console.
 * - Each class has only one reason to change, adhering to the Single Responsibility Principle.
 * - Future classes (like "Future Class") can be easily integrated without modifying existing ones.
 */

/**
 * The SingleResponsibility_1 class demonstrates the Single Responsibility Principle (SRP).
 *
 * <p>
 * A class should have only one reason to change.
 * This example separates concerns: Marker, Invoice, saving to the database, and printing are handled by different classes.
 * </p>
 */
public class S_ingleResponsibility {

    // Marker class only responsible for holding marker data
    class Marker {
        private final String name;
        private final String color;
        private final int year;
        private final int price;

        public Marker(String name, String color, int year, int price) {
            this.name = name;
            this.color = color;
            this.year = year;
            this.price = price;
        }

        // Getter methods to access private properties
        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public int getYear() {
            return year;
        }

        public int getPrice() {
            return price;
        }
    }

    // Invoice class responsible for calculating total price based on marker quantity
    class Invoice {
        private final Marker marker;
        private final int quantity;

        public Invoice(Marker marker, int quantity) {
            this.marker = marker;
            this.quantity = quantity;
        }

        // Calculates the total cost for the markers based on quantity
        public int calculateTotal() {
            int price = marker.getPrice() * this.quantity;
            return price;
        }

        // Getter method for marker
        public Marker getMarker() {
            return marker;
        }

        // Getter method for quantity
        public int getQuantity() {
            return quantity;
        }
    }

    // InvoiceDao class responsible for handling data storage (simulated with a print statement)
    class InvoiceDao {
        private final Invoice invoice;

        public InvoiceDao(Invoice invoice) {
            this.invoice = invoice;
        }

        // Simulates saving invoice to a database
        public void saveToDatabase() {
            System.out.println("Invoice for marker " + invoice.getMarker().getName() + " saved to database.");
        }
    }

    // InvoicePrinter class responsible for printing the invoice details
    class InvoicePrinter {
        private final Invoice invoice;

        public InvoicePrinter(Invoice invoice) {
            this.invoice = invoice;
        }

        // Simulates printing the invoice to the console
        public void print() {
            System.out.println("Printing Invoice:");
            System.out.println("Marker: " + invoice.getMarker().getName());
            System.out.println("Color: " + invoice.getMarker().getColor());
            System.out.println("Quantity: " + invoice.getQuantity());
            System.out.println("Total Price: $" + invoice.calculateTotal());
        }
    }

    // Main method to run the example
    public static void main(String[] args) {
        S_ingleResponsibility sr = new S_ingleResponsibility();

        // Create a marker
        Marker marker = sr.new Marker("Expo", "Black", 2023, 5);

        // Create an invoice for the marker
        Invoice invoice = sr.new Invoice(marker, 10);

        // Print the invoice
        InvoicePrinter printer = sr.new InvoicePrinter(invoice);
        printer.print();

        // Save the invoice to the database
        InvoiceDao dao = sr.new InvoiceDao(invoice);
        dao.saveToDatabase();
    }
}

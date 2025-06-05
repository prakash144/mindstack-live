/**
 * Class and Interface Relationship Diagram (Flow Chart / Mind Map)
 *
 *                            +---------------------+
 *                            |    InvoiceDao       |
 *                            |  (Interface)        |
 *                            +---------------------+
 *                                      |
 *      +-------------------------------+------------------------------+
 *      |                                                              |
 *      |                                                              |
 * +------------------------+                               +------------------------+
 * |   DatabaseInvoiceDao    |                               |    FileInvoiceDao      |
 * | (Implements InvoiceDao) |                               | (Implements InvoiceDao)|
 * +------------------------+                               +------------------------+
 *             |                                                            |
 *             |                                                            |
 *             v                                                            v
 *   save(SingleResponsibility_1.Invoice)                        save(SingleResponsibility_1.Invoice)
 *  (Saves to a database)                                       (Saves to a file)
 *
 * Main class: OpenClosed_2
 * - Responsible for holding different InvoiceDao implementations and demonstrating the save operations.
 * - It can be extended with new InvoiceDao implementations (e.g., CloudInvoiceDao) without modifying the main class.
 *
 * Open for Extension but closed for Modification
 */

/**
 * The OpenClosed_2 class demonstrates the use of the Open/Closed Principle by allowing
 * multiple types of invoice saving mechanisms without modifying the class itself.
 */
public class O_penClosed {

    interface InvoiceDao {
        // Method to save an invoice
        void save(S_ingleResponsibility.Invoice invoice);
    }

    /**
     * Implementation of InvoiceDao for saving to a database.
     * This class can be extended or modified independently without changing other save mechanisms.
     */
    class DatabaseInvoiceDao implements InvoiceDao {
        @Override
        public void save(S_ingleResponsibility.Invoice invoice) {
            // Simulated saving to a database
            System.out.println("Invoice for marker " + invoice.getMarker().getName() + " saved to database.");
        }
    }

    /**
     * Implementation of InvoiceDao for saving to a file.
     * This class can be extended or modified independently without changing other save mechanisms.
     */
    class FileInvoiceDao implements InvoiceDao {
        @Override
        public void save(S_ingleResponsibility.Invoice invoice) {
            // Simulated saving to a file
            System.out.println("Invoice for marker " + invoice.getMarker().getName() + " saved to file.");
        }
    }

    // Main method to demonstrate the Open/Closed Principle in action
    public static void main(String[] args) {
        // Assuming SingleResponsibility_1.Invoice is defined and available
        S_ingleResponsibility sr1 = new S_ingleResponsibility();
        S_ingleResponsibility.Invoice invoice = sr1.new Invoice(sr1.new Marker("Expo", "Black", 2023, 5), 10);

        // Use the DatabaseInvoiceDao to save the invoice to a database
        O_penClosed oc2 = new O_penClosed();
        InvoiceDao databaseDao = oc2.new DatabaseInvoiceDao();
        databaseDao.save(invoice);

        // Use the FileInvoiceDao to save the invoice to a file
        InvoiceDao fileDao = oc2.new FileInvoiceDao();
        fileDao.save(invoice);
    }
}

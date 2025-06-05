public class DoubleCheckedLockingWithVolatileDBConnection {

    // Volatile ensures visibility across threads and prevents instruction reordering.
    private static volatile DoubleCheckedLockingWithVolatileDBConnection connectionObj;
    int memberVariable;

    // Private constructor to prevent instantiation from outside.
    private DoubleCheckedLockingWithVolatileDBConnection(int memberVariable) {
        this.memberVariable = memberVariable;
    }

    public static DoubleCheckedLockingWithVolatileDBConnection getInstance() {
        // First null check without synchronization for performance.
        if (connectionObj == null) {
            // Synchronize only when instance is being created.
            synchronized (DoubleCheckedLockingWithVolatileDBConnection.class) {
                // Double-check if instance is still null after acquiring the lock.
                if (connectionObj == null) {
                    // Create instance, volatile prevents issues with caching and reordering.
                    connectionObj = new DoubleCheckedLockingWithVolatileDBConnection(10);
                }
            }
        }
        System.out.println("Hello from Double-Checked Locking Singleton using volatile!");
        return connectionObj;
    }
}

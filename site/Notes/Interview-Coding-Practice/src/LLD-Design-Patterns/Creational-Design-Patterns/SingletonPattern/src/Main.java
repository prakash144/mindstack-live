public class Main {
    public static void main(String[] args) {

        // Eager initialization
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();

        // Lazy initialization
        LazySingleton lazySingleton = LazySingleton.getInstance();

        // Synchronized Singleton
        SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();

        // Double-Checked Locking Singleton
        DoubleCheckedLockingSingleton doubleCheckedSingleton = DoubleCheckedLockingSingleton.getInstance();

        // volatile variable read nad write from memory and skip the cache
        DoubleCheckedLockingWithVolatileDBConnection doubleCheckedLockingWithVolatileDBConnectionSingleton = DoubleCheckedLockingWithVolatileDBConnection.getInstance();

    }
}
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    // Private constructor to prevent instantiation
    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if(instance == null) {
            instance = new SynchronizedSingleton();
        }
        System.out.println("Hello from Synchronized Singleton!");
        return instance;
    }
}

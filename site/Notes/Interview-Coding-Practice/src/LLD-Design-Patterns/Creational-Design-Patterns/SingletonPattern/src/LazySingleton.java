public class LazySingleton {

    private static LazySingleton instance;

    // Private constructor to prevent instantiation
    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        System.out.println("Hello from Lazy Singleton!");
        return instance;
    }
}

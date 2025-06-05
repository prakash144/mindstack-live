public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent instantiation
    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        System.out.println("Hello from Eager Singleton!");
        return instance;
    }

}

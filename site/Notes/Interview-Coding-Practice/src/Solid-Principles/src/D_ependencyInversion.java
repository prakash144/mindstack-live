/**
 * This class demonstrates the Dependency Inversion Principle (DIP).
 * DIP states that high-level modules should depend on abstractions (interfaces) rather than concrete classes.
 * <p>
 * FLOWCHART:
 * <p>
 *    +--------------------+         +------------------+
 *    |     Keyboard        |         |      Mouse       |
 *    +--------------------+         +------------------+
 *    | + type()            |         | + click()        |
 *    +--------------------+         +------------------+
 *       /         \                      /          \
 *  +------------------+         +------------------------+
 *  | WiredKeyboard     |         |      WiredMouse        |
 *  +------------------+         +------------------------+
 *  | + type()         |         | + click()              |
 *  +------------------+         +------------------------+
 * <p>
 *  +-----------------------+    +---------------------------+
 *  |   BluetoothKeyboard    |    |     BluetoothMouse        |
 *  +-----------------------+    +---------------------------+
 *  | + type()              |    | + click()                 |
 *  +-----------------------+    +---------------------------+
 * <p>
 * - MacBook class depends on interfaces (Keyboard, Mouse) rather than concrete implementations.
 * - This allows flexibility and easy substitution of different implementations.
 */

public class D_ependencyInversion {

    // Defines keyboard-related actions
    interface Keyboard {
        void type();
    }

    // Defines mouse-related actions
    interface Mouse {
        void click();
    }

    // Implements a wired keyboard
    class WiredKeyboard implements Keyboard {
        public void type() {
            System.out.println("Typing on Wired Keyboard");
        }
    }

    // Implements a Bluetooth keyboard
    class BluetoothKeyboard implements Keyboard {
        public void type() {
            System.out.println("Typing on Bluetooth Keyboard");
        }
    }

    // Implements a wired mouse
    class WiredMouse implements Mouse {
        public void click() {
            System.out.println("Clicking with Wired Mouse");
        }
    }

    // Implements a Bluetooth mouse
    class BluetoothMouse implements Mouse {
        public void click() {
            System.out.println("Clicking with Bluetooth Mouse");
        }
    }

    // MacBook depends on abstractions (Keyboard, Mouse) rather than concrete classes
    class MacBook {
        private final Keyboard keyboard;
        private final Mouse mouse;

        public MacBook(Keyboard keyboard, Mouse mouse) {
            this.keyboard = keyboard;
            this.mouse = mouse;
        }

        // Simulates using the peripherals
        public void useLaptop() {
            keyboard.type();
            mouse.click();
        }
    }

    // Main method to run the code
    public static void main(String[] args) {
        D_ependencyInversion instance = new D_ependencyInversion();

        // Creating instances of Wired peripherals
        Keyboard wiredKeyboard = instance.new WiredKeyboard();
        Mouse wiredMouse = instance.new WiredMouse();

        // Using MacBook with wired peripherals
        MacBook macWithWired = instance.new MacBook(wiredKeyboard, wiredMouse);
        macWithWired.useLaptop();

        // Creating instances of Bluetooth peripherals
        Keyboard bluetoothKeyboard = instance.new BluetoothKeyboard();
        Mouse bluetoothMouse = instance.new BluetoothMouse();

        // Using MacBook with Bluetooth peripherals
        MacBook macWithBluetooth = instance.new MacBook(bluetoothKeyboard, bluetoothMouse);
        macWithBluetooth.useLaptop();
    }
}

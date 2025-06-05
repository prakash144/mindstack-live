/*
    +------------------------------------+
    |        Client (Main)               |
    +------------------------------------+
                    |
                    v
    +-----------------------------+    +------------------------------+
    |  Invoker (MyRemoteControl)  |    |   Receiver (AirConditioner)  |
    +-----------------------------+    +------------------------------+
                    |                                 |
                    | holds                           | executes
                    v                                 v
    +-------------------------------+           +--------------------------------------+
    |  Command Interface (ICommand)  |<--use--->|  Concrete Commands (TurnACOnCommand, |
    |  - execute()                   |          |  TurnACOffCommand)                   |
    |  - undo()                      |          +--------------------------------------+
    +--------------------------------+

    Flow:
    1. Client (Main) creates commands (e.g., TurnACOnCommand) with a receiver (AirConditioner).
    2. Client assigns commands to the invoker (MyRemoteControl).
    3. Invoker executes the command, which calls methods on the receiver (AirConditioner).
    4. The undo functionality reverses the last command.
*/

public class Main {
    public static void main(String[] args) {

        // AC Object (Receiver)
        AirConditioner airConditioner = new AirConditioner();

        // Remote Control (Invoker)
        MyRemoteControl remoteObj = new MyRemoteControl();

        // Create the command to turn on AC and press the button
        remoteObj.setCommand(new TurnACOnCommand(airConditioner));
        remoteObj.pressButton();

        // Undo the last operation
        remoteObj.undoButton();
    }
}
/*
*              +--------------------+
               |   Client (Main)    |
               +--------------------+
                        |
                        v
              +--------------------------+
              | ConfigurationOriginator  |
              |  (Creates and Restores   |
              |     Mementos)            |
              +--------------------------+
                        |
                        v
              +--------------------------+
              |  ConfigurationMemento    |
              | (Stores the snapshot of  |
              |     Originator's state)  |
              +--------------------------+
                        |
                        v
              +--------------------------+
              | ConfigurationCareTaker   |
              | (Stores and manages      |
              |  mementos for undo)      |
              +--------------------------+

        +---------------------------------------------+
        | Create ConfigurationOriginator (Editor)     |
        | with initial state (height = 5, width = 10) |
        +---------------------------------------------+
                          |
                          v
        +-------------------------------------------+
        | Create and Save Memento (Snapshot 1)      |
        +-------------------------------------------+
                          |
                          v
        +-------------------------------------------+
        | Change state (height = 7, width = 10)     |
        +-------------------------------------------+
                          |
                          v
        +-------------------------------------------+
        | Create and Save Memento (Snapshot 2)      |
        +-------------------------------------------+
                          |
                          v
        +-------------------------------------------+
        | Change state (height = 10, width = 10)    |
        +-------------------------------------------+
                          |
                          v
        +-------------------------------------------+
        | Undo -> Restore Memento (Snapshot 2)      |
        +-------------------------------------------+
                          |
                          v
        +-------------------------------------------+
        | State reverted to height = 7, width = 10  |
        +-------------------------------------------+

 */

public class Client {
    public static void main(String[] args) {
        ConfigurationCareTaker careTakerObj = new ConfigurationCareTaker();

        // Initiate State of originator
        ConfigurationOriginator originatorObj = new ConfigurationOriginator(5,10);

        // Save it
        ConfigurationMemento snapshot1 = originatorObj.createMemento();
        // Add it to history
        careTakerObj.addMemento(snapshot1);

        // originator changing it the new state
        originatorObj.setHeight(7);
        originatorObj.setWidth(10);

        // Save it
        ConfigurationMemento snapshot2 = originatorObj.createMemento();

        // Add it ti history
        careTakerObj.addMemento(snapshot2);

        // originator changing ot to new state
        originatorObj.setHeight(10);
        originatorObj.setWidth(10);

        // UNDO
        ConfigurationMemento restoreMementoObj1 = careTakerObj.undo();
        originatorObj.restoreMemento(restoreMementoObj1);

        System.out.println("height: "+ originatorObj.height + " width: "+ originatorObj.width);
    }
}
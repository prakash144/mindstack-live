/*

       +----------------------------------+
       |          Client (Main)           |
       +----------------------------------+
                     |
                     v
       +----------------------------------+
       |       Facade (RemoteControl)     |
       +----------------------------------+
                     |
       +-------------+------------+-------+
       |                          |
       v                          v
    +----------+            +---------------+
    |   TV     |            | SoundSystem   |
    +----------+            +---------------+
       |                              |
       +---------------+--------------+
                       v
              +------------------+
              | DVD Player/Game  |
              +------------------+


 */

public class Main {
    public static void main(String[] args) {

        // Creating subsystems
        TV tv = new TV();
        SoundSystem soundSystem = new SoundSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();

        // Facade "is-a" interface to simplify complex subsystems
        RemoteControl remoteControl = new RemoteControl(tv, soundSystem, dvdPlayer);

        // Simplified access via Facade
        remoteControl.startMovie("Inception");
    }
}
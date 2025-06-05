public class RemoteControl {
    private TV tv;
    private SoundSystem soundSystem;
    private DVDPlayer dvdPlayer;

    // "has-a" relationship: Facade has instances of subsystems
    public RemoteControl(TV tv, SoundSystem soundSystem, DVDPlayer dvdPlayer) {
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.dvdPlayer = dvdPlayer;
    }

    public void startMovie(String movie) {
        System.out.println("Get ready for movie night...");
        tv.turnOn();
        tv.setInputChannel();
        soundSystem.turnOn();
        soundSystem.setVolume(30);
        dvdPlayer.turnOn();
        dvdPlayer.playMovie(movie);
    }
}

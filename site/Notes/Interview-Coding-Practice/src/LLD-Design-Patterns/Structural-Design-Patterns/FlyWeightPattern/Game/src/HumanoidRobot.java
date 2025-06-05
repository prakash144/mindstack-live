public class HumanoidRobot implements IRobot {

    private String type;
    private Sprites body; // small 2D bitmap (graphic elements) // Flyweight shared object

    HumanoidRobot(String type, Sprites body){
        this.type = type;
        this.body = body;
    }

    // Only Getter methods

    public String getType(){
        return type;
    }

    public Sprites getBody(){
        return body;
    }

    @Override
    public void display(int x, int y) {
        // use the humanoid robot sprites objet
        // and X and Y coordinate to render the image.
        // Render the humanoid robot at coordinates (x, y) using the shared sprite.
        System.out.println("Humanoid Robot (" + type + ") is displayed at coordinates: (" + x + ", " + y + ")");
    }
}

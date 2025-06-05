import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RoboticFactory {

    private static final Map<String, IRobot> roboticObjectCache = new HashMap<>();

    public static IRobot createRobot(String robotType) {
        if (roboticObjectCache.containsKey(robotType)) {
            return roboticObjectCache.get(robotType);
        } else {
            if(Objects.equals(robotType, "HUMANOID")){
                Sprites humanoidSprite = new Sprites();
                IRobot humanoidObject = new HumanoidRobot(robotType, humanoidSprite);
                roboticObjectCache.put(robotType, humanoidObject);
                return humanoidObject;
            } else if(Objects.equals(robotType, "ROBOTICDOG")){
                Sprites robotDogSprites = new Sprites();
                IRobot robotDogObject = new RoboticDog(robotType, robotDogSprites);
                roboticObjectCache.put(robotType, robotDogObject);
                return robotDogObject;
            }
        }
        return null;
    }
}

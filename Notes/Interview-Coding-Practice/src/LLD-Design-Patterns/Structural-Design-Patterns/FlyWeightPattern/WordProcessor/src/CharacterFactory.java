import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {

    private static Map<Character, ICharacter> charactersCache = new HashMap<Character, ICharacter>();

    public static ICharacter createCharacter(char character) {
        if (charactersCache.containsKey(character)) {
            return charactersCache.get(character);
        }
        else {
            DocumentsCharacter characterObj = new DocumentsCharacter(character, "Arial", 10);
            charactersCache.put(character, characterObj);
            return characterObj;
        }
    }

}

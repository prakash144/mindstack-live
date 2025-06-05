public class DocumentsCharacter implements ICharacter{

    private char character;
    private String fontType;
    private int size;

    DocumentsCharacter(char character, String fontType, int size) {
        this.character = character;
        this.fontType = fontType;
        this.size = size;
    }

    //only getter methods

    @Override
    public void display(int row, int column) {
        // Extrinsic state: x and y position, and specific style for this character
        System.out.println("Character: " + character + " | Font: " + fontType + " | Position: (" + row + "," + column + ") | size: " + size);
    }
}

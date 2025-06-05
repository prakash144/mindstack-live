public class Main {
    public static void main(String[] args) {
         /*
            this is the data we want to write into the word processor.

            Total = 58 characters
            t = 7 times
            h = 3 times
            a = 3 times and so on...

         */

        ICharacter object1 = CharacterFactory.createCharacter('t');
        object1.display(0,0);

        ICharacter object2 = CharacterFactory.createCharacter('t');
        object1.display(0,6);

    }
}
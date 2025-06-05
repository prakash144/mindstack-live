/*

                        +---------------------------+
                        |        Client (Main)      |
                        +---------------------------+
                                         |
                                         v
                        +----------------------------+
                        |     FileSystem (Interface) |
                        +----------------------------+
                                         |
                   +---------------------+------------------+
                   |                                        |
     +---------------------------+          +---------------------------+
     |      Directory (Class)    |          |        File (Class)       |
     +---------------------------+          +---------------------------+
                   |                                        |
      has-a List<FileSystem>                         is-a FileSystem
                   |
                   v
    +-----------------------------------+
    | List of File and Directory Objects|
    +-----------------------------------+


 */


public class Main {
    public static void main(String[] args) {

        Directory movieDirectory = new Directory("Movie");

        FileSystem border = new File("Border");
        movieDirectory.add(border);

        Directory comedyMovieDirectory = new Directory("ComedyMovie");
        File hulchal = new File("Hulchal");
        comedyMovieDirectory.add(hulchal);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();
    }
}
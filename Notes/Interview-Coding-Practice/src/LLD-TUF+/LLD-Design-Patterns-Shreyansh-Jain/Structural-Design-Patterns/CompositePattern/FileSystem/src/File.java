public class File implements FileSystem{

    String fileName;

    public File(String name) {
        this.fileName = name;
    }

    @Override
    public void ls() {
        System.out.println("file name:" + fileName);
    }
}

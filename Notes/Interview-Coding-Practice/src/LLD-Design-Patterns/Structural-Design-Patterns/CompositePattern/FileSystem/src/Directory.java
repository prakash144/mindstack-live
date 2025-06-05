import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    String directoryName;
    List<FileSystem> fileSystemsList;

    public Directory(String name) {
        this.directoryName = name;
        fileSystemsList = new ArrayList<>();
    }

    public void add(FileSystem fileSystemObj) {
        fileSystemsList.add(fileSystemObj);
    }

    @Override
    public void ls() {
        System.out.println("Directory name: " + directoryName);
        for (FileSystem fileSystemObj : fileSystemsList) {
            fileSystemObj.ls();
        }
    }
}

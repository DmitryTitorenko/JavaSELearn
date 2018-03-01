package more.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Dmitry Titorenko on 19.02.2018
 */
public class Metadata {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\Metadata.txt");

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                System.out.println("Create: " + path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        getBasicFileAttributes(path);

    }

    public static void getBasicFileAttributes(Path file) {
        try {
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

            System.out.println("creationTime: " + attr.creationTime());
            System.out.println("lastAccessTime: " + attr.lastAccessTime());
            System.out.println("lastModifiedTime: " + attr.lastModifiedTime());


            System.out.println("isDirectory: " + attr.isDirectory());
            System.out.println("isOther: " + attr.isOther());
            System.out.println("isRegularFile: " + attr.isRegularFile());
            System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
            System.out.println("size: " + attr.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

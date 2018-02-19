package more.io;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Dmitry Titorenko on 19.02.2018
 */
public class CheckIsFileExist {
    public static boolean checkIsFileExist(Path... paths) {
        boolean isExist = false;
        for (Path path : paths) {
            isExist = false;
            if (Files.exists(path)) {
                isExist = true;
            } else {
                try {
                    Files.createFile(path);
                } catch (FileAlreadyExistsException x) {
                    System.err.format("file named %s" + " already exists%n", path);
                } catch (IOException x) {
                    // Some other sort of failure, such as permissions.
                    System.err.format("createFile error: %s%n", x);
                }
            }
        }
        return isExist;
    }
}

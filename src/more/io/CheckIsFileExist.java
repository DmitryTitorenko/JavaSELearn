package more.io;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Dmitry Titorenko on 19.02.2018
 */
public class CheckIsFileExist {

    /**
     * Add file if he didn't exist
     *
     * @param paths which need to check.
     * @return true if file exist and false if didn't exist and we add this file.
     */
    public static boolean addFileIfItDoNotExist(Path... paths) {
        boolean isExist = false;
        for (Path path : paths) {
            isExist = false;
            if (Files.exists(path)) {
                isExist = true;
            } else {
                try {
                    Files.createFile(path);

                    System.out.println("Create " + path.toString());
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

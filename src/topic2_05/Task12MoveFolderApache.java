package topic2_05;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 28.02.2018
 * <p>
 * 3.12 Перемещение файлов
 * <p>
 * Решить предыдущую задачу с использованием средств перемещения (переименования) файлов.
 */
public class Task12MoveFolderApache {
    public static void main(String[] args) {
        Path pathSource = Paths.get("C:/folderSource");
        Path pathDestination = Paths.get("C:/folderDestination");

        File srcDir = new File(pathSource.toString());
        File destDir = new File(pathDestination.toString());

        try {
            FileUtils.moveDirectory(srcDir, destDir);
            FileUtils.deleteDirectory(srcDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


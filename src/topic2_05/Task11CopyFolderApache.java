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
 * 3.11 Копирование файлов*
 * <p>
 * До начала выполнения программы создать каталог с несколькими файлами.
 * В программе создать новый каталог и скопировать туда файлы из ранее созданного.
 * Удалить ранее созданный каталог.
 */
public class Task11CopyFolderApache {
    public static void main(String[] args) {
        Path pathSource = Paths.get("C:/folderSource");
        Path pathDestination = Paths.get("C:/folderDestination");

        File srcDir = new File(pathSource.toString());
        File destDir = new File(pathDestination.toString());

        try {
            Files.createDirectory(pathDestination);
            FileUtils.copyDirectory(srcDir, destDir);
            FileUtils.deleteDirectory(srcDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

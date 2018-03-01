package topic2_05;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * @author Dmitry Titorenko on 01.03.2018
 * <p>
 * 3.14 Отслеживание состояния каталога*
 * <p>
 * Реализовать программу отслеживания появления, изменения и удаления в заданном каталоге файлов с расширением .txt.
 * Использовать средства пакета java.nio.file.
 * <p>
 * see https://docs.oracle.com/javase/tutorial/essential/io/notification.html
 * "Watching a Directory for Changes"
 */
public class Task14WatchService {

    public static void main(String[] args) throws Exception {
        Path dir = Paths.get("D:\\1");

        // Create a new WatchService
        WatchService watcher = FileSystems.getDefault().newWatchService();

        // Registering an object with the watch service
        WatchKey key = dir.register(watcher, ENTRY_DELETE, ENTRY_MODIFY);

        // wait for key to be signaled
        while (true) {
            key = watcher.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent<Path> ev = (WatchEvent<Path>) event;

                Path filename = ev.context();

                // Verify that the .txt file modify or deleted ( .txt is "text/plaint' type)
                try {
                    if (Files.probeContentType(filename).equals("text/plain")) {
                        System.err.format("File '%s'" +
                                " is change .%n", filename);
                        continue;
                    }
                } catch (IOException x) {
                    System.err.println(x);
                    continue;
                }
            }
            // Reset the key -- this step is critical if you want to
            // receive further watch events.  If the key is no longer valid,
            // the directory is inaccessible so exit the loop.
            key.reset();
        }
    }
}

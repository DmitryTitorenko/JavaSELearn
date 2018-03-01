package topic2_05;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * @author Dmitry Titorenko on 01.03.2018
 * <p>
 * 3.13 Обход дерева каталогов*
 * <p>
 * Ввести имя подкаталога и осуществить поиск всех скрытых файлов во всех подкаталогах, начиная с некоторого каталога.
 * <p>
 * see https://docs.oracle.com/javase/tutorial/essential/io/walk.html
 * "Walking the File Tree"
 */
public class Task13WalkingTheFileTree {
    public static void main(String[] args) {

        Path path = Paths.get("D:\\1");
        Print print = new Print();

        try {
            Files.walkFileTree(path, print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print if file hidden and each directory visited.
     * <p>
     * To walk a file tree, you first need to implement a FileVisitor interface
     * or extend the SimpleFileVisitor class (this class implements the FileVisitor interface,
     * visits all files in a tree and throws an IOError when an error is encountered)
     */
    static class Print extends SimpleFileVisitor<Path> {

        // Print information about
        // each type of file.
        @Override
        public FileVisitResult visitFile(Path file,
                                         BasicFileAttributes attr) {
            try {
                DosFileAttributes dosFileAttributes = Files.readAttributes(file, DosFileAttributes.class);
                if (dosFileAttributes.isHidden()) {
                    System.out.println("Hidden: " + file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return CONTINUE;
        }

        // Print each directory visited.
        @Override
        public FileVisitResult postVisitDirectory(Path dir,
                                                  IOException exc) {
            System.out.format("Directory: %s%n", dir);
            return CONTINUE;
        }
    }
}

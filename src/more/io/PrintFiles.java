package more.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.*;

/**
 * @author Dmitry Titorenko on 01.03.2018
 * <p>
 * Pring information about all files in current and inner directore (walking file tree).
 */

public class PrintFiles {
    public static void main(String[] args) {

        Path path = Paths.get("D:\\1");
        Print print = new Print();

        try {
            Files.walkFileTree(path, print);//  Print all entries in a file tree
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print information about each type of file and each directory visited.
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
            if (attr.isSymbolicLink()) {
                System.out.format("Symbolic link: %s ", file);
            } else if (attr.isRegularFile()) {
                System.out.format("Regular file: %s ", file);
            } else if (attr.isOther()) {
                System.out.format("Other: %s ", file);
            }
            System.out.println("(" + attr.size() + "bytes)");

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


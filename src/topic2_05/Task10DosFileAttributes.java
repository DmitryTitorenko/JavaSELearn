package topic2_05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

/**
 * @author Dmitry Titorenko on 28.02.2018
 * <p>
 * 3.10 Получение информации об атрибутах файлов*
 * <p>
 * Разработать программу, которая для заданного файла (каталога) выдает информацию об его атрибутах.
 * Использовать класс DosFileAttributes.
 */
public class Task10DosFileAttributes {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\");
        try {
            DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println("is System: " + dosFileAttributes.isSystem() +
                    "\ncreationTime: " + dosFileAttributes.creationTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

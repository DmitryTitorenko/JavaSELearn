package topic2_05;

import java.io.File;
import java.io.IOException;

/**
 * @author Dmitry Titorenko on 28.02.2018
 * <p>
 * 3.9 Работа с классом File*
 * <p>
 * Создать новый файл в корневой папке проекта.
 * Вывести список файлов и папок корневой папки проекта.
 * Удалить только что созданный файл.
 * Использовать класс java.io.File.
 */
public class Task9IOFile {
    public static void main(String[] args) {
        File currentDir = new File("."); // Current folder
        try {
            if (currentDir.createNewFile()) ;
            System.out.println("created");

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String e : currentDir.list()) {
            System.out.println(e);
        }
        if (currentDir.delete()) {
            System.out.println("deleted");
        }
    }
}

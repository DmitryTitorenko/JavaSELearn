package topic2_05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dmitry Titorenko on 30.01.2018
 * <p>
 * 3.2 Текстовые файлы с числовыми данными
 * <p>
 * Разработать программу, которая осуществляет чтение из текстового файла действительных значений (до конца файла),
 * находит произведение модулей ненулевых элементов и выводит в другой текстовый файл.
 */
public class Task2 {

    private static String pathReadFile = "C:\\task2Read.txt";
    private static String pathWriteFile = "C:\\task2Write.txt";
    private static long composition = 1;
    private static List<Integer> arrayLine = new ArrayList<>();

    public static void main(String[] args) {
        createFile();
        readFile();
        math();
        writeData();
    }

    /**
     * Check if file doesn't exist, create him and write original data
     */
    private static void createFile() {
        Path pathRead = Paths.get(pathReadFile);
        Path pathWrite = Paths.get(pathWriteFile);

        try {
            if (Files.notExists(pathRead)) {
                Files.createFile(pathRead);
                writeOriginalData();
            }
            if (Files.notExists(pathWrite)) {
                Files.createFile(pathWrite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOriginalData() {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(pathReadFile))) {
            printWriter.println(2);
            printWriter.println(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void math() {
        Iterator<Integer> integerIterator = arrayLine.listIterator();
        while (integerIterator.hasNext()) {
            composition *= integerIterator.next();
        }
    }

    private static void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathReadFile))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(" ");
                for (String i : array) {
                    int element = Math.abs(Integer.parseInt(i));
                    if (element != 0) {
                        arrayLine.add(element);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData() {
        try (PrintWriter printWriter = new PrintWriter(pathWriteFile)) {
            printWriter.print(composition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

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


    private static long composition = 1;
    private static List<Integer> arrayLine = new ArrayList<>();

    public static void main(String[] args) {

        Path pathRead = Paths.get("C:\\task2Read.txt");
        Path pathWrite = Paths.get("C:\\task2Write.txt");

        createFile(pathRead, pathWrite);
        readFile(pathRead);
        math();
        writeData(pathWrite);
    }

    /**
     * Check if file doesn't exist, create him and write original data
     */
    private static void createFile(Path pathRead, Path pathWrite) {

        try {
            if (Files.notExists(pathRead)) {
                Files.createFile(pathRead);
                writeOriginalData(pathRead);
            }
            if (Files.notExists(pathWrite)) {
                Files.createFile(pathWrite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOriginalData(Path path) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path.toString()))) {
            printWriter.println(2);
            printWriter.println(2);
            printWriter.println("Some");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readFile(Path path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(" ");
                for (String i : array) {
                    if (checkIsStringNumber(i)) {
                        int element = Math.abs(Integer.parseInt(i));
                        if (element != 0) {
                            arrayLine.add(element);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIsStringNumber(String s) {
        boolean end = true;
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            end = false;
        }
        return end;
    }

    private static void math() {
        Iterator<Integer> integerIterator = arrayLine.listIterator();
        while (integerIterator.hasNext()) {
            composition *= integerIterator.next();
        }
    }

    private static void writeData(Path path) {
        try (PrintWriter printWriter = new PrintWriter(path.toString())) {
            printWriter.print(composition);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

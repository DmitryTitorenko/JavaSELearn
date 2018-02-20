package topic2_05;

import more.io.CheckIsFileExist;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 20.02.2018
 * <p>
 * 3.3 Работа с несколькими файлами*
 * <p>
 * Разработать программу, которая осуществляет чтение из текстового файла целых чисел и сохранение в двух файлах данных (DataOutputStream)
 * соответственно четных и нечетных чисел. В другой программе прочитать данные из двух файлов данных (DataInputStream)
 * и записать их в новый текстовый файл в порядке убывания. Использовать PriorityQueue для обеспечения упорядоченности чисел.
 */
public class Task3 {
    public static void main(String[] args) {
        Path pathRead = Paths.get("C:\\task3Read.txt");
        Path pathWriteEvenNumber = Paths.get("C:\\task3EvenNumber.txt");
        Path pathWriteUnevenNumber = Paths.get("C:\\task3UnEvenNumber.txt");

        if (!CheckIsFileExist.addFileIfItDoNotExist(pathRead, pathWriteEvenNumber, pathWriteUnevenNumber)) {
            writeToFile(pathRead);
        }
        saveNumberFromReadingFile(pathRead, pathWriteEvenNumber, pathWriteUnevenNumber);
    }

    private static void writeToFile(Path path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString()))) {
            bufferedWriter.write("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveNumberFromReadingFile(Path pathRead, Path pathEveNumber, Path pathUnevenNumber) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathRead.toString()))) {
            StringBuilder sb = new StringBuilder();

            int i = bufferedReader.read();
            if (i != -1) {
                sb.appendCodePoint(i);

                while (i != -1) {
                    if (checkIsStringInt(sb.toString())) {
                        System.out.println(sb.toString());
                    }
                    sb.delete(0, 2);
                    i = bufferedReader.read();
                    if (i != -1) {
                        sb.appendCodePoint(i);
                    }
                }
            } else {
                System.out.println("Empty File");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIsStringInt(String s) {
        boolean end = true;
        try {
            Integer.parseInt(s);

        } catch (NumberFormatException e) {
            end = false;
        }
        return end;
    }
}

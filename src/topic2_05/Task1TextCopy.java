package topic2_05;

import more.io.CheckIsFileExist;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 30.01.2018
 * <p>
 * 3.1 Работа с текстовыми файлами
 * <p>
 * Разработать программу, которая осуществляет копирование из одного текстового файла в другой.
 * Осуществить копирование только тех строк, длина которых не превосходит введенного значения.
 */
public class Task1TextCopy {
    public static void main(String[] args) {
        Path pathFrom = Paths.get("C:\\Task1TextCopyFrom.txt");
        Path pathTo = Paths.get("C:\\Task1TextCopyTo.txt");
        if (!CheckIsFileExist.addFileIfItDoNotExist(pathFrom, pathTo)) {
            writeToFile(pathFrom);
        }
        textCopy(3, pathFrom, pathTo);
    }

    public static void writeToFile(Path path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString()))) {

            bufferedWriter.write("1");
            bufferedWriter.newLine();
            bufferedWriter.write("22");
            bufferedWriter.newLine();
            bufferedWriter.write("333");
            bufferedWriter.newLine();
            bufferedWriter.write("4444");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void textCopy(int matLength, Path pathFrom, Path pathTo) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFrom.toString()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathTo.toString()))) {
            StringBuilder sb = new StringBuilder();

            while (!(sb.append(bufferedReader.readLine())).toString().equals("null")) {
                if (sb.length() <= matLength) {
                    bufferedWriter.write(sb.toString());
                    bufferedWriter.newLine();
                }
                sb.delete(0, sb.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
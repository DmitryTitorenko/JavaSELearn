package topic2_05;

import java.io.*;

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
        textCopy(4);
    }

    public static void textCopy(int i) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Task1TextCopyFrom.txt"));
             PrintWriter printWriter = new PrintWriter("C:\\Task1TextCopyTo.txt")) {

            String line;
            String[] arrayLine;
            while ((line = bufferedReader.readLine()) != null) {
                arrayLine = line.split(" ");
                for (String e : arrayLine) {
                    if (e.length() <= i) {
                        printWriter.print(e + " ");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


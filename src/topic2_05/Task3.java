package topic2_05;

import more.io.CheckIsFileExist;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.PriorityQueue;

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

    private static Path pathRead;
    private static Path pathEvenNumber;
    private static Path pathUnevenNumber;
    private static Path pathIncreasingOrder;
    private static PriorityQueue<Integer> integers = new PriorityQueue<>(Collections.reverseOrder());


    public static void main(String[] args) {
        pathRead = Paths.get("C:\\task3Read.txt");
        pathEvenNumber = Paths.get("C:\\task3EvenNumber.txt");
        pathUnevenNumber = Paths.get("C:\\task3UnEvenNumber.txt");
        pathIncreasingOrder = Paths.get("C:\\task3IncreasingOrder.txt");

        String initialData = "22 55 11 2 ";

        if (!CheckIsFileExist.addFileIfItDoNotExist(pathRead, pathEvenNumber, pathUnevenNumber, pathIncreasingOrder)) {
            writeToFile(initialData);
        }
        parsingFile();

        readNumberForm2Files();

        writeNumbersByOrder();
    }

    /**
     * Write initial data to file.
     *
     * @param initialData write to empty file.
     */
    private static void writeToFile(String initialData) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathRead.toString()))) {
            bufferedWriter.write(initialData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create BufferedReader stream and parsing data form file
     */
    private static void parsingFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathRead.toString()));
             DataOutputStream dataOutputStreamEvent = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathEvenNumber.toString())));
             DataOutputStream dataOutputStreamUneven = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathUnevenNumber.toString())))) {

            StringBuilder sb = new StringBuilder(); // Store single character
            StringBuilder sbNumber = new StringBuilder(); // Store number as single character '1' or  sequence of characters '11'
            int codePoint = bufferedReader.read();

            if (codePoint != -1) {
                sb.appendCodePoint(codePoint);

                while (codePoint != -1) {
                    findNumbers(codePoint, sb, sbNumber, dataOutputStreamEvent, dataOutputStreamUneven);
                    sb.delete(0, 2);
                    codePoint = bufferedReader.read();

                    if (codePoint != -1) {
                        sb.appendCodePoint(codePoint);
                    }
                }
            } else {
                System.out.println("Empty File");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if this code point is number.
     *
     * @param codePoint Code point
     * @param sb        Single character
     * @param sbNumber  Store number
     */
    public static void findNumbers(int codePoint, StringBuilder sb, StringBuilder sbNumber, DataOutputStream dataOutputStreamEvent, DataOutputStream dataOutputStreamUneven) {

        if (codePoint == 32) { // check if this code point is space
            writeNumbers(Integer.parseInt(sbNumber.toString()), dataOutputStreamEvent, dataOutputStreamUneven);
            sbNumber.delete(0, sbNumber.length());

        } else {
            if (isNumber(sb.toString())) {
                sbNumber.append(sb.toString());
            }
        }
    }

    /**
     * Write number to even number file or uneven number file.
     *
     * @param i Number to write
     */
    private static void writeNumbers(int i, DataOutputStream dataOutputStreamEvent, DataOutputStream dataOutputStreamUneven) {
        try {
            if (i % 2 == 0) {
                dataOutputStreamEvent.writeInt(i);
            } else {
                dataOutputStreamUneven.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if this string store number.
     *
     * @param s String of character
     * @return true if this string store number
     */
    private static boolean isNumber(String s) {
        boolean result = true;
        try {
            Integer.parseInt(s);

        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    private static void readNumberForm2Files() {
        try (DataInputStream dataInputStreamEven = new DataInputStream(new BufferedInputStream(new FileInputStream(pathEvenNumber.toString())));
             DataInputStream dataInputStreamUneven = new DataInputStream(new BufferedInputStream(new FileInputStream(pathUnevenNumber.toString())))) {


            try {
                while (dataInputStreamEven.available() > 0) {
                    integers.add(dataInputStreamEven.readInt());
                }
                while (dataInputStreamUneven.available() > 0) {
                    integers.add(dataInputStreamUneven.readInt());
                }
            } catch (EOFException e) {
                e.printStackTrace();
            }
            System.out.println(integers.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeNumbersByOrder() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathIncreasingOrder.toString()))) {
            while (integers.peek() != null) {
                bufferedWriter.write(String.valueOf(integers.poll()) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

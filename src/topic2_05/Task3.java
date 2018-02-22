package topic2_05;

import more.io.CheckIsFileExist;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public static void main(String[] args) {
        Path pathRead = Paths.get("C:\\task3Read.txt");
        Path pathEvenNumber = Paths.get("C:\\task3EvenNumber.txt");
        Path pathUnevenNumber = Paths.get("C:\\task3UnEvenNumber.txt");
        Path pathIncreasingOrder = Paths.get("C:\\task3IncreasingOrder.txt");

        if (!CheckIsFileExist.addFileIfItDoNotExist(pathRead, pathEvenNumber, pathUnevenNumber)) {
            writeToFile(pathRead);
        }
        findNumbersFromFile(pathRead, pathEvenNumber, pathUnevenNumber);

        writeNumbersByOrder(pathEvenNumber, pathUnevenNumber, pathIncreasingOrder);
    }

    private static void writeToFile(Path path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString()))) {
            bufferedWriter.write("22 ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findNumbersFromFile(Path pathRead, Path pathEvenNumber, Path pathUnevenNumber) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathRead.toString()));
             DataOutputStream dataOutputStreamEvent = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathEvenNumber.toString())));
             DataOutputStream dataOutputStreamUneven = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathUnevenNumber.toString())))) {

            StringBuilder sb = new StringBuilder();
            StringBuilder sbSum = new StringBuilder();

            int i = bufferedReader.read();
            if (i != -1) {
                sb.appendCodePoint(i);

                while (i != -1) {
                    if (i == 32) {

                        writeNumbers(Integer.parseInt(sbSum.toString()), dataOutputStreamEvent, dataOutputStreamUneven);

                        sbSum.delete(0, sbSum.length());

                    } else {

                        if (checkIsStringInt(sb.toString())) {
                            sbSum.append(sb.toString());

                        }
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


    private static boolean checkIsStringInt(String s) {
        boolean end = true;
        try {
            Integer.parseInt(s);

        } catch (NumberFormatException e) {
            end = false;
        }
        return end;
    }

    private static void writeNumbersByOrder(Path patEvenNumber, Path pathUnevenNumber, Path pathIncreasingOrder) {
        try (DataInputStream dataInputStreamEven = new DataInputStream(new BufferedInputStream(new FileInputStream(patEvenNumber.toString())));
             DataInputStream dataInputStreamUneven = new DataInputStream(new BufferedInputStream(new FileInputStream(pathUnevenNumber.toString())))) {

            PriorityQueue<Integer> integers = new PriorityQueue<>();

            try {
                while (dataInputStreamEven.available() > 0) {
                    integers.add(dataInputStreamEven.readInt());
                }
            } catch (EOFException e) {
                e.printStackTrace();
            }
            System.out.println(integers.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

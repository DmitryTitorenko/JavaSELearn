package more.io;

import java.io.*;

/**
 * FileWriter and FileReader stores character values using Unicode conventions
 *
 * @author Dmitry Titorenko on 16.02.2018
 */
public class CharacterStream {
    public static void main(String[] args) {
        writeCharacter();
        readCharacter();
        // bufferWriteCharacter();
        //  bufferedReadCharacter();
    }

    private static void writeCharacter() {
        try (FileWriter fileWriter = new FileWriter("C:\\writeCharacter.txt")) {
            fileWriter.write("Ё ");
            fileWriter.write("o ");
            fileWriter.write("1 ");
            fileWriter.write(34);  // code point of 34 == "

            //if we want to add formatting data, need use PrintWriter
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.format(" %f", 34.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readCharacter() {
        try (FileReader fileReader = new FileReader("C:\\writeCharacter.txt")) {
            StringBuilder stringBuilder = new StringBuilder();

            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.print(stringBuilder.appendCodePoint(i));
                stringBuilder.delete(0, 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferWriteCharacter() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\writeCharacter.txt"))) {
            bufferedWriter.append("Ё");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedReadCharacter() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\writeCharacter.txt"))) {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

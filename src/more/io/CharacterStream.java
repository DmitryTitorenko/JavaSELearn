package more.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * FileWriter and FileReader stores character values using Unicode conventions
 *
 * @author Dmitry Titorenko on 16.02.2018
 */
public class CharacterStream {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\writeCharacter.txt");
        CheckIsFileExist.addFileIfItDoNotExist(path);

        writeCharacter(path);
        readCharacter(path);
        bufferWriteCharacter(path);
        bufferedReadCharacter(path);
    }

    private static void writeCharacter(Path path) {
        try (FileWriter fileWriter = new FileWriter(path.toString())) {
            fileWriter.write("Ё ");
            fileWriter.write("o ");
            fileWriter.write("1   \r\n");
            fileWriter.write("1   \r\n");
            fileWriter.write(34);  // code point of 34 == "

            //if we want to add formatting data, need use PrintWriter
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.format(" %f \r\n", 34.0);
            printWriter.format(" %f \n", 34.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readCharacter(Path path) {
        try (FileReader fileReader = new FileReader(path.toString())) {
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

    private static void bufferWriteCharacter(Path path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString()))) {
            bufferedWriter.write("Ё");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedReadCharacter(Path path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toString()))) {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

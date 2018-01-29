package topic2_05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author Dmitry Titorenko on 29.01.2018
 */
public class MyTextWrite {
    public static void main(String[] args) {
        writeFile();
        readFile();
    }

    // Write by symbol
    // Don't need pw.close(); uses try-with-resources
    private static void writeFile() {
        try (FileWriter fw = new FileWriter("C:\\temp.txt")) {
            PrintWriter pw = new PrintWriter(fw);
            pw.print(59);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        try (FileReader fileReader = new FileReader("C:\\temp.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

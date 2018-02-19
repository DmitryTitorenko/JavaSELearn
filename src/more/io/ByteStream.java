package more.io;

import java.io.*;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 05.02.2018
 */
public class ByteStream {
    public static void main(String[] args) {

        if (CheckIsFileExist.checkIsFileExist(Paths.get("C:\\bufferByteStreamRead.txt"),
                Paths.get("C:\\bufferByteStreamWrite.txt"),
                Paths.get("C:\\bufferByteStreamRead.txt"),
                Paths.get("C:\\bufferByteStreamWrite.txt"))){
            copyBytes();
            bufferCopyBytes();
        }
    }

    private static void copyBytes() {
        try (FileInputStream in = new FileInputStream("C:\\bufferByteStreamRead.txt");
             FileOutputStream out = new FileOutputStream("C:\\bufferByteStreamWrite.txt")) {
            int i;

            while ((i = in.read()) != -1) {
                out.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferCopyBytes() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\bufferByteStreamRead.txt"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\bufferByteStreamWrite.txt"))) {
            out.write(in.readAllBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

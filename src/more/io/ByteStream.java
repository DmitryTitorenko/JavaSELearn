package more.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 05.02.2018
 */
public class ByteStream {
    public static void main(String[] args) {
        Path pathByteStreamRead = Paths.get("C:\\ByteStreamRead.txt");
        Path pathByteStreamWrite = Paths.get("C:\\ByteStreamWrite.txt");

        if (!CheckIsFileExist.addFileIfItDoNotExist(pathByteStreamRead, pathByteStreamWrite)) {
            writeToFile(pathByteStreamRead);
        }

        copyBytes(pathByteStreamRead, pathByteStreamWrite);
        bufferCopyBytes(pathByteStreamRead, pathByteStreamWrite);
    }

    private static void writeToFile(Path pathByteStreamRead) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathByteStreamRead.toString()))) {
            bufferedWriter.write("1 1 1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyBytes(Path pathByteStreamRead, Path pathByteStreamWrite) {
        try (FileInputStream in = new FileInputStream(pathByteStreamRead.toString());
             FileOutputStream out = new FileOutputStream(pathByteStreamWrite.toString())) {
            int i;

            while ((i = in.read()) != -1) {
                out.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferCopyBytes(Path pathByteStreamRead, Path pathByteStreamWrite) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(pathByteStreamRead.toString()));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pathByteStreamWrite.toString()))) {
            out.write(in.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

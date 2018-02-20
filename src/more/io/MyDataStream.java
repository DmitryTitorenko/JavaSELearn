package more.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 29.01.2018
 */
public class MyDataStream {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\DataStream.txt");
        CheckIsFileExist.addFileIfItDoNotExist(path);
        writeStream(path);
        readStream(path);
    }

    // Write in binary format
    private static void writeStream(Path path) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path.toString())))) {
            dataOutputStream.writeUTF("go");
            dataOutputStream.writeInt(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readStream(Path path) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(path.toString())))) {
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

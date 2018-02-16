package more.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;

/**
 * @author Dmitry Titorenko on 29.01.2018
 */
public class MyDataStream {
    public static void main(String[] args) {
        writeStream();
        readStream();
    }

    // Write in binary format
    private static void writeStream() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\tempDataOutputStream.txt")))) {
            dataOutputStream.writeUTF("go");
            dataOutputStream.writeInt(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readStream() {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\tempDataOutputStream.txt")))) {
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

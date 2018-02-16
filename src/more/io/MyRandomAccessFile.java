package more.io;

import java.io.RandomAccessFile;

/**
 * @author Dmitry Titorenko on 29.01.2018
 */
public class MyRandomAccessFile {
    public static void main(String[] args) {
        randomAccessFileWrite();
        randomAccessFileRead();
    }

    public static void randomAccessFileWrite() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\MyRandomAccessFile.txt", "rw")) {
            randomAccessFile.writeInt(1);
            randomAccessFile.writeInt(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void randomAccessFileRead() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\MyRandomAccessFile.txt", "rw")) {
            randomAccessFile.skipBytes(4);
            System.out.println(randomAccessFile.readInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

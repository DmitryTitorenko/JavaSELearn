package more.io;

import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 29.01.2018
 */
public class MyRandomAccessFile {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\RandomAccessFile.txt");
        CheckIsFileExist.addFileIfItDoNotExist(path);
        randomAccessFileWrite(path);
        randomAccessFileRead(path);
    }

    public static void randomAccessFileWrite(Path path) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path.toString(), "rw")) {
            randomAccessFile.writeInt(1);
            randomAccessFile.writeInt(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void randomAccessFileRead(Path path) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path.toString(), "rw")) {
            randomAccessFile.skipBytes(4);
            System.out.println(randomAccessFile.readInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

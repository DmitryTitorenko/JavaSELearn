package topic2_05;

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
    private static void writeStream(){
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("C:\\tempDataOutputStream.txt"))) {
            dataOutputStream.writeUTF("go");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    private static void readStream(){
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream("C:\\tempDataOutputStream.txt"))) {
            System.out.println(dataInputStream.readUTF());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

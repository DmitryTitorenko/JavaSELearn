package more.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 30.01.2018
 */
public class MySerialization {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\SerializationPC.txt");
        CheckIsFileExist.addFileIfItDoNotExist(path);
        serializationPC(path);
        deserializationPC(path);
    }

    public static void serializationPC(Path path) {
        PC pc = new PC();
        pc.setCPU("AMD");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            objectOutputStream.writeObject(pc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializationPC(Path path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toString()))) {
            PC pc = (PC) objectInputStream.readObject();
            System.out.println(pc.getCPU());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PC implements Serializable {
    private static final long serialVersionUID = -3861862668546826739L;
    private String CPU = "Intel";

    // transient -  don't serialization field
    private transient String color;

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }
}



package more.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 30.01.2018
 */
public class MySerialization {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\SerializationPC.data");
        CheckIsFileExist.addFileIfItDoNotExist(path);

        PC pc = new PC();
        pc.setCPU("AMD");
        serializationPC(pc, path);

        pc = deserializationPC(path);
        System.out.println(pc.getCPU());
    }

    public static void serializationPC(PC pc, Path path) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            objectOutputStream.writeObject(pc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PC deserializationPC(Path path) {
        PC pc = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toString()))) {
            pc = (PC) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pc;
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



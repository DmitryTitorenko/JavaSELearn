package topic2_05;

import java.io.*;

/**
 * @author Dmitry Titorenko on 30.01.2018
 */
public class MySerialization {
    public static void main(String[] args) {
        serializationPC();
        deserializationPC();
    }

    public static void serializationPC() {
        PC pc = new PC();
        pc.setCPU("AMD");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\SerializationPC.txt"))) {
            objectOutputStream.writeObject(pc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializationPC() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\SerializationPC.txt"))) {
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



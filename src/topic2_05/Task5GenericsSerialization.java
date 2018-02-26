package topic2_05;

import more.io.CheckIsFileExist;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 26.02.2018
 * <p>
 * 3.5 Сериализация и десериализация объектов обобщенных классов*
 * <p>
 * Описать классы "Учебное заведение" и "Массив" (обобщенный класс).
 * Создать массив объектов "Учебное заведение", осуществить сериализацию и десериализацию.
 */
public class Task5GenericsSerialization {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Task5GenericsSerialization.data");
        CheckIsFileExist.addFileIfItDoNotExist(path);

        School[] arraySchool = {new School(1, "School №1"),
                new School(2, "School №2")};

        ArrayGeneral<School> arrayG = new ArrayGeneral<>(arraySchool);
        arraySerializable(arrayG, path);

        arrayG = arrayDeSerializable(path);
        System.out.println(arrayG.toString());
    }

    /**
     * Serialization general array.
     *
     * @param path   to file
     * @param arrayG general array
     */

    private static void arraySerializable(ArrayGeneral arrayG, Path path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            objectOutputStream.writeObject(arrayG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserialization general array.
     *
     * @param path to file
     */
    private static ArrayGeneral arrayDeSerializable(Path path) {
        ArrayGeneral arrayG = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toString()))) {
            arrayG = (ArrayGeneral) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return arrayG;
    }
}

class School implements Serializable {
    private static final long serialVersionUID = -2611862668546826739L;
    private int id;
    private String name;

    School(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Name: " + name;
    }
}

/**
 * General array.
 */
class ArrayGeneral<T> implements Serializable {
    private static final long serialVersionUID = -1621862668546826739L;
    private T[] t;

    ArrayGeneral(T[] t) {
        this.t = t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T i : this.t) {
            sb.append(i.toString()).append("\n");
        }
        return sb.toString();
    }
}



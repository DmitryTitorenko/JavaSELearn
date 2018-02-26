package topic2_05;

import more.io.CheckIsFileExist;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dmitry Titorenko on 25.02.2018
 * <p>
 * 3.4 Реализация сериализации и десериализации*
 * <p>
 * Описать классы Студент и Академическая группа (с массивом студентов в качестве поля).
 * Создать объекты, осуществить их сериализацию и десериализацию.
 */
public class Task4Serialization {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Task4Serialization.data");
        CheckIsFileExist.addFileIfItDoNotExist(path);

        Student student1 = new Student(1, "Tommy");
        Student student2 = new Student(2, "Jon");
        AcademicGroup academicGroup = new AcademicGroup(1, student1, student2);

        serializableStud(student1, path);
        Student desStudent = deSerializableStud(path);
        System.out.println("Deserializable Student: \n" + desStudent);

        serializableAG(academicGroup, path);
        AcademicGroup ag = deSerializableAG(path);
        System.out.println("Deserializable academic group: \n" + ag.toString());
    }


    /**
     * Serializable class Student.
     *
     * @param student object to serializable
     * @param path    to file
     */
    private static void serializableStud(Student student, Path path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * DeSerializable class Student.
     *
     * @param path to file which contain object of class Student
     * @return Student deserializable object
     */
    private static Student deSerializableStud(Path path) {
        Student student = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toString()))) {
            student = (Student) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * Serializable class AcademicGroup.
     *
     * @param academicGroup object to serializable
     * @param path          to file
     */
    private static void serializableAG(AcademicGroup academicGroup, Path path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            objectOutputStream.writeObject(academicGroup);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * DeSerializable class AcademicGroup.
     *
     * @param path to file which contain object of class Student
     * @return AcademicGroup deserializable object
     */
    private static AcademicGroup deSerializableAG(Path path) {
        AcademicGroup ag = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toString()))) {
            ag = (AcademicGroup) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return ag;
    }
}

/**
 * Class Student with transient field name.
 */
class Student implements Serializable {
    private static final long serialVersionUID = -3661862668546826739L;
    private int id;
    transient private String name; //don't serializable field

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}

/**
 * Contain array of class Student.
 */
class AcademicGroup implements Serializable {
    private static final long serialVersionUID = -3761862668546826739L;
    private int id;
    private Student[] students;

    AcademicGroup(int id, Student... students) {
        this.students = students;
        this.id = id;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Student a : students) {
            sb.append(a.toString()).append(" ");
        }
        return "GroupID: " + id + "\n" + sb.toString();
    }
}

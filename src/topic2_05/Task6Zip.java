package topic2_05;

import more.io.CheckIsFileExist;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.*;

/**
 * @author Dmitry Titorenko on 26.02.2018
 * <p>
 * 3.6 Работа с ZIP-архивом*
 * <p>
 * Описать классы Студент и Академическая группа (с массивом студентов в качестве поля).
 * Создать объекты Студент и Академическая группа, осуществить запись данных о студентах академической группы в архив (ZIP).
 * В другой программе осуществить чтение из архива.
 * <p>
 * see "Compressing and Decompressing Data Using Java APIs"
 * http://www.oracle.com/technetwork/articles/java/compress-1565076.html
 */
public class Task6Zip {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Task6Zip.zip");
        CheckIsFileExist.addFileIfItDoNotExist(path);

        Student student1 = new Student(1, "Tommy");
        Student student2 = new Student(2, "Jon");
        AcademicGroup academicGroup = new AcademicGroup(1, student1, student2);

        outputZip(path, student1, academicGroup);
        inputZip(path);

        writeObject(student1);
        readObject();
    }

    /**
     * Create ZIP from object Student and AcademicGroup.
     *
     * @param path          to file
     * @param student1      to zip as String
     * @param academicGroup to zip as String
     */
    private static void outputZip(Path path, Student student1, AcademicGroup academicGroup) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(path.toString()))) {

            ZipEntry zipEntry = new ZipEntry(student1.toString());
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.closeEntry();

            zipEntry = new ZipEntry(academicGroup.toString());
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.closeEntry();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read data about student and academic group form .zip file.
     *
     * @param path to file
     */
    private static void inputZip(Path path) {

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(path.toString()))) {

            System.out.println(zipInputStream.getNextEntry().toString());
            zipInputStream.closeEntry();

            System.out.println(zipInputStream.getNextEntry().toString());
            zipInputStream.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create ZIP from object Student.
     *
     * @param student object to compressing to zip file
     */
    private static void writeObject(Student student) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("C:\\Task6ZipObject.zip")))) {

            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get decompressing object of student form zip file.
     */
    private static void readObject() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new GZIPInputStream(new FileInputStream("C:\\Task6ZipObject.zip")))) {

            Student student = (Student) objectInputStream.readObject();
            System.out.println(student.toString());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}


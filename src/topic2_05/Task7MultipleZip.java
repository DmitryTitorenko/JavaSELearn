package topic2_05;

import more.io.CheckIsFileExist;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/**
 * @author Dmitry Titorenko on 27.02.2018
 * <p>
 * 3.7 Архивация нескольких файлов*
 * <p>
 * Реализовать две программы, одна из которых осуществляет архивацию нескольких указанных файлов, а другая – извлечение их из архива.
 * <p>
 * see http://www.baeldung.com/java-compress-and-uncompress  "Zipping and Unzipping in Java"
 */
public class Task7MultipleZip {
    public static void main(String[] args) {

        Path pathSource = Paths.get("C:\\Task7ToZip1.txt");
        CheckIsFileExist.addFileIfItDoNotExist(pathSource);
        writeData(pathSource, "111");

        Path pathSource2 = Paths.get("C:\\Task7ToZip2.txt");
        CheckIsFileExist.addFileIfItDoNotExist(pathSource2);
        writeData(pathSource2, "222");

        Path pathContain = Paths.get("C:\\Task7Zip.zip");
        CheckIsFileExist.addFileIfItDoNotExist(pathContain);

        zipFiles(pathContain, pathSource, pathSource2);

        unZipFiles(pathContain);
    }

    /**
     * Create ZIP from files.
     *
     * @param pathCompressed to zip file
     * @param pathSources    to files
     */
    private static void zipFiles(Path pathCompressed, Path... pathSources) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(pathCompressed.toString()))) {

            FileInputStream fis;
            for (Path path : pathSources) {
                fis = new FileInputStream(path.toString());
                ZipEntry zipEntry = new ZipEntry(path.toString().substring(3, path.toString().length()));
                zipOut.putNextEntry(zipEntry);

                final byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create unZIP from file.
     *
     * @param path to zip file
     */
    private static void unZipFiles(Path path) {
        final byte[] bytes = new byte[1024];

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(path.toString()))) {
            ZipEntry zipEntry = zipIn.getNextEntry();
            FileOutputStream fos;
            while (zipEntry != null) {

                Path pathNew = Paths.get(correctPath(zipEntry.getName()));
                Files.createFile(pathNew);
                int length;
                fos = new FileOutputStream(pathNew.toString());

                while ((length = zipIn.read(bytes)) > 0) {
                    fos.write(bytes, 0, length);
                }

                fos.close();
                zipEntry = zipIn.getNextEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create correct path from entry name.
     *
     * @param s to zip file
     */

    private static String correctPath(String s) {
        int i = s.indexOf(".");
        return "C:\\" +
                s.substring(0, i) +
                "Unzipping" +
                s.substring(i, s.length());
    }

    /**
     * Write initial data to file
     *
     * @param path to file
     * @param s    data
     */
    private static void writeData(Path path, String s) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString()))) {
            bufferedWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




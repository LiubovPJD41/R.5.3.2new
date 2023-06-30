
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {

        // создадим экземпляр класса сохраненной игры
        GameProgress gameProgressFirst = new GameProgress(12, 78, 3, 147.8);
        GameProgress gameProgressSecond = new GameProgress(8, 34, 3, 103.1);
        GameProgress gameProgressThird = new GameProgress(5, 56, 2, 108.4);

        saveGames("C://Games//saveGames//save1.dat", gameProgressFirst);
        saveGames("C://Games//saveGames//save2.dat", gameProgressSecond);
        saveGames("C://Games//saveGames//save3.dat", gameProgressThird);

        zipFiles("C://Games//saveGames//zip1.zip", "C://Games//saveGames//save1.dat");
        zipFiles("C://Games//saveGames//zip2.zip", "C://Games//saveGames//save2.dat");
        zipFiles("C://Games//saveGames//zip3.zip", "C://Games//saveGames//save3.dat");

        deleteFile("C://Games//saveGames//save1.dat");
        deleteFile("C://Games//saveGames//save2.dat");
        deleteFile("C://Games//saveGames//save3.dat");
    }

    public static void saveGames(String path, GameProgress gameProgress) {
        // откроем выходной поток для записи в файл
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // запишем экземпляр класса в файл
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //String address = "C://Games//saveGames//zip1.zip"    Sting path = "C://Games//saveGames//save1.dat"
    //String address = "C://Games//saveGames//zip2.zip"    Sting path = "C://Games//saveGames//save2.dat"
    //String address = "C://Games//saveGames//zip3.zip"    Sting path = "C://Games//saveGames//save3.dat"

    public static void zipFiles(String address, String path) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(address));
             FileInputStream fis = new FileInputStream(path)) {
            ZipEntry entry = new ZipEntry(path);
            zout.putNextEntry(entry);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
            System.out.println("File deleted!");
        } else
            System.out.println("File not found");
    }
}


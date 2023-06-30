import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static  void main(String[] args) {

        // создадим экземпляр класса сохраненной игры
        GameProgress gameProgressFirst = new GameProgress(12, 78, 3, 147.8);
        GameProgress gameProgressSecond = new GameProgress(8, 34, 3, 103, 1);
        GameProgress gameProgressThird = new GameProgress(5, 56, 2, 108.4);

        //path1 = "C://Games//saveGames//save1.dat"
        //path2 = "C://Games//saveGames//save2.dat"
        //path3 = "C://Games//saveGames//save3.dat"

    }
        public void saveGamse(String path,GameProogress gameProgress){
            // откроем выходной поток для записи в файл
            try (FileOutputStream fos = new FileOutputStream(path);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                // запишем экземпляр класса в файл
                oos.writeObject(gameProgress);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        File pathDir = null;
        String[] pathsFilesAndDir;

        AnchorPane root = FXMLLoader.load(getClass().getResource("Control.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Diplom");
        primaryStage.setScene(new Scene(root, 900, 600));

            List<String> list = new ArrayList<String>();
            Scanner in = new Scanner(new File("Testler\\test1.txt"));
            while (in.hasNextLine())
                list.add(in.nextLine());
            String[] array = list.toArray(new String[0]);
            int x = 0;
        for (int i = 0; i < array.length ; i++) {

            if (!Objects.equals(array[i], "")) {
                System.out.println(array[i]);
                x=0;
            } else {
                x+=1;
                if(x<=1){
                    System.out.println("new");
                }
            }
        }
        try {
            // Создание нового объекта file
            pathDir = new File("Testler"); // Обязательно должен существовать указанный каталог на диске, иначе программа выдаст ошибку

            // Массив файлов и папок
            pathsFilesAndDir = pathDir.list();

            for(String path:pathsFilesAndDir) {
                // Вывод списка файлов и каталогов
                System.out.println(path+" qq");
            }
        }catch(Exception e) {
            System.out.println(" ex");
        }

        primaryStage.show();
}
}
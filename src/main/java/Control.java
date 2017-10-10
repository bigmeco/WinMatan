import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Control {
    public ListView file;
    public ImageView img;
    public Label jisla;

    @FXML
    private Button start;
    ObservableList<String> names = FXCollections
            .observableArrayList();
    File pathDir = null;
    String[] pathsFilesAndDir;
    String vib;
    String[] array = {};

    private final long[] frameTimes = new long[10];
    private int frameTimeIndex = 0;

    @FXML
    public void initialize() {

        try {
            // Создание нового объекта file

            pathDir = new File("Testler"); // Обязательно должен существовать указанный каталог на диске, иначе программа выдаст ошибку

            // Массив файлов и папок
            pathsFilesAndDir = pathDir.list();
            file.getItems().addAll(pathsFilesAndDir);

        } catch (Exception e) {
            e.printStackTrace();
        }

        file.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<String>) (ov, old_val, new_val) -> {
                    vib = new_val;
                    start.setDisable(false);
                });

        img.setVisible(false);


    }


    public void Start(ActionEvent actionEvent) throws FileNotFoundException {


        List<String> list = new ArrayList<String>();

        Scanner in = new Scanner(new File("Testler\\" + vib));
        while (in.hasNextLine())
            list.add(in.nextLine());
        array = list.toArray(new String[0]);
        int x = 0;

        for (int i = 0; i < array.length; i++) {

            if (!Objects.equals(array[i], "")) {
                System.out.println(array[i]);
                x = 0;
            } else {
                x += 1;
                if (x <= 1) {
                    System.out.println("new");
                }
            }
        }

        AnimationTimer frameRateMeter = new AnimationTimer() {

            @Override
            public void handle(long now) {

                System.out.println(frameTimeIndex);
                frameTimeIndex = (frameTimeIndex + 1) ;
                if(frameTimeIndex ==array.length){

                }



                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                jisla.setText(String.valueOf(array[frameTimeIndex]));



            }
        };
        frameRateMeter.start();



    }

    private void setJisla() throws FileNotFoundException {

    }
}



import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Control {

    public Slider skorost;
    public Button Otveti;
    public Slider kolzad;
    @FXML
    private ListView file;
    @FXML
    private ImageView img;
    @FXML
    private Label jisla;
    @FXML
    private Button Dalee;
    @FXML
    private Button start;

    private File pathDir = null;
    private String[] pathsFilesAndDir;
    private String vib;
    private AnimationTimer frameRateMeter;
    private int frameTimeIndex = 0;
    private int o = 1;
    private List<Integer> listZ = new ArrayList<>();
    private List<Integer> listJ = new ArrayList<>();
    private List<Integer> listOt = new ArrayList<>();
    private long Skor = 500;
    private int KolZad = 0;
    private int sumPl = 0;

    @FXML
    public void initialize() {

        try {
            pathDir = new File("Testler");
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

        skorost.valueProperty().addListener((observable, oldValue, newValue) -> {
            Double d = newValue.doubleValue() * 1000;
            Skor = d.longValue();
        });
        kolzad.valueProperty().addListener((observable, oldValue, newValue) -> {
            KolZad = newValue.intValue();
        });
    }


    public void Start(ActionEvent actionEvent) throws FileNotFoundException {
        img.setVisible(false);
        file.setDisable(true);
        List<String> list = new ArrayList<>();

        Scanner in = new Scanner(new File("Testler\\" + vib));
        while (in.hasNextLine()){
            list.add(in.nextLine());
        }
        int x = 0;
        int s=0;
        int sum = 0;


        for (int i = 0; i < list.size(); i++) {
            if (!Objects.equals(list.get(i), "")) {
                s++;
                x = 0;
            } else {
                x += 1;
                if (x <= 1) {
                    listZ.add(s);
                }
            }
        }
        listZ.add(s);

        System.out.println(listZ);
        for (int f = 0; f <list.size() ; f++) {
            if (!Objects.equals(list.get(f), "")) {
                sum += Integer.parseInt(list.get(f));
                listJ.add(Integer.parseInt(list.get(f)));
                x = 0;
            } else {
                x += 1;
                listOt.add(sum);
                sum = 0;
        }
        }

        for (int i = 0; i <2 ; i++) {
            setJisla(Skor, listJ, listZ.get(0));
        }
        frameRateMeter.start();
        start.setVisible(false);
        Dalee.setVisible(true);
        Otveti.setVisible(true);
    }

    private void setJisla(long time, List listJ, int col) throws FileNotFoundException {
        frameRateMeter = new AnimationTimer() {

            @Override
            public void handle(long now) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                jisla.setText(String.valueOf(listJ.get(frameTimeIndex)));
                System.out.println(listJ.get(frameTimeIndex));
                System.out.println(frameTimeIndex);
                frameTimeIndex++;
                if (frameTimeIndex == col) {
                    frameRateMeter.stop();
                    Otveti.setDisable(false);
                    Dalee.setDisable(false);
                }
            }
        };
    }


    public void Dalee(ActionEvent actionEvent) throws FileNotFoundException {
        if(KolZad!=o) {
            setJisla(Skor, listJ, listZ.get(o));
            frameRateMeter.start();
            o++;
            if (!Otveti.isDisable()) {
                sumPl++;
            }
            Otveti.setDisable(true);
            Dalee.setDisable(true);
        } else {
            start.setVisible(true);
            Dalee.setVisible(false);
            Otveti.setVisible(false);
        }
    }

    public void Otveti(ActionEvent actionEvent) {
        System.out.println(listOt);
        jisla.setText(String.valueOf(listOt.get(sumPl)));
        sumPl++;
        Otveti.setDisable(true);
    }
}



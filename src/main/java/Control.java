import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Control {
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



    }


    public void Start(ActionEvent actionEvent) throws FileNotFoundException {
        img.setVisible(false);
        file.setDisable(true);
        List<String> list = new ArrayList<String>();
        HashMap<Integer,Integer> MapZd = new HashMap<>() ;
        Scanner in = new Scanner(new File("Testler\\" + vib));
        while (in.hasNextLine()){
            list.add(in.nextLine());
        }
        int x = 0;
        int s=0;

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
                listJ.add(Integer.parseInt(list.get(f)));
                x = 0;
            } else {
                x += 1;
        }
        }
        System.out.println(listJ);
        for (int i = 0; i <2 ; i++) {
            setJisla(400,listJ,listZ.get(0));
        }

        frameRateMeter.start();


        start.setVisible(false);
        Dalee.setVisible(true);
    }

    private void setJisla(int time, List listJ,int col) throws FileNotFoundException {

        frameRateMeter = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (frameTimeIndex == col- 1) {
                    frameRateMeter.stop();
                }

                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                jisla.setText(String.valueOf(listJ.get(frameTimeIndex)));

                System.out.println(listJ.get(frameTimeIndex));
                System.out.println(frameTimeIndex);
                frameTimeIndex++;
            }

        };
    }

    public void Dalee(ActionEvent actionEvent) throws FileNotFoundException {

        setJisla(400,listJ,listZ.get(o));
        frameRateMeter.start();
        o++;
    }
}



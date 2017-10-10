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

        AnchorPane root = FXMLLoader.load(getClass().getResource("Control.fxml"));

        primaryStage.setTitle("Diplom");
        primaryStage.setScene(new Scene(root, 900, 600));

        primaryStage.show();

}
}
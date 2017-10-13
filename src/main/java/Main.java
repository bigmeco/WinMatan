import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane root = FXMLLoader.load(getClass().getResource("StartLogo.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setMinHeight(540);
        primaryStage.setMinWidth(700);
        primaryStage.setTitle("Diplom");
        primaryStage.setScene(new Scene(root, 700, 540));
        primaryStage.show();

}

}
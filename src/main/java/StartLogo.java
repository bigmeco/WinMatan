import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartLogo {


    public void Start(ActionEvent actionEvent) throws IOException {
        Stage Prepods = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/Control.fxml"));
        Prepods.setMinHeight(600);
        Prepods.setMinWidth(900);
        Prepods.setScene(new Scene(root, 900, 600));

        Prepods.show();
    }
}

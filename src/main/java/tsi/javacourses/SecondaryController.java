package tsi.javacourses;

import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SecondaryController {



    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void stopGame(ActionEvent actionEvent) {
        Platform.exit();
    }
}
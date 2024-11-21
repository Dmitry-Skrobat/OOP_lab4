package application.Interface;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.Number;


import java.io.IOException;

public class ChangeMaxOdd {

    @FXML
    private Button backMenu;

    @FXML
    private TextField changeMax;

    @FXML
    void initialize() {
        backMenu.setOnAction(actionEvent -> back());
    }

    private boolean handleSubmit() {
        try {
            String rootsInput = changeMax.getText();
            Number fixedOdd = new Number();
            fixedOdd = fixedOdd.scannerNumber(rootsInput);
            Menu.polinom.changeFixedOdds(fixedOdd);
            return true;
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка ввода");
            alert.setHeaderText("Некорректные данные");
            alert.setContentText("Пожалуйста, убедитесь, что степень введена корректно.");
            alert.showAndWait();
            return false;
        }
    }
    private void back(){
        if(handleSubmit()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/menu.fxml"));

                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) backMenu.getScene().getWindow();
                stage.setScene(scene);
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

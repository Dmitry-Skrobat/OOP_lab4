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

public class Calculate {

    @FXML
    private Button backMenu;

    @FXML
    private Button calculate;

    @FXML
    private TextField inputX;

    @FXML
    void initialize() {
        backMenu.setOnAction(actionEvent -> back());
        calculate.setOnAction(actionEvent -> calculateNumber());
    }

    private void calculateNumber() {
        String inputNumber = inputX.getText();
        Number number = new Number();
        number = number.scannerNumber(inputNumber);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Посчитать значение в точке");
        alert.setHeaderText("Значение в заданной точке");
        alert.setContentText(Menu.polinom.calculate(number));
        alert.showAndWait();
    }

    private void back(){
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

package application.Interface;

import application.Array;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.Number;
import application.Polinom;


import java.io.IOException;



public class CreatePolinom {

    @FXML
    private Button backMenu;

    @FXML
    private TextField degree;

    @FXML
    private TextField inputRoots;

    @FXML
    private TextField maxFixedOdds;


    @FXML
    void initialize() {
        backMenu.setOnAction(actionEvent -> back());
    }

    private boolean handleSubmit() {
        try {
            String rootsInput = inputRoots.getText();
            String degreeInput = degree.getText();
            String maxFixedOddInput = maxFixedOdds.getText();
            int degree = Integer.parseInt(degreeInput);
            if(degree<0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка ввода");
                alert.setHeaderText("Некорректные данные");
                alert.setContentText("Пожалуйста, убедитесь, что степень введена корректно она не должна быть меньше 0.");
                alert.showAndWait();
                return false;
            }
            Number fixedOdd = new Number();
            fixedOdd = fixedOdd.scannerNumber(maxFixedOddInput);
            Array fixedOdds = new Array(1);
            fixedOdds.insertElement(0,fixedOdd);
            String[] rootsScan = rootsInput.split(",");
            Array roots = new Array(rootsScan.length);
            for (int i = 0;i<rootsScan.length;i++){
                Number root = new Number();
                root = root.scannerNumber(rootsScan[i]);
                roots.insertElement(i,root);
            }
            Menu menu = new Menu();
            Menu.polinom = new Polinom(roots,fixedOdds,degree);
            Menu.polinom.showWithFixedOdds();
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


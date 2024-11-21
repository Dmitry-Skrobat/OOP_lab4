package application.Interface;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import application.Polinom;

import java.io.IOException;

public class Menu {


    public static Polinom polinom;

    @FXML
    private Button calculate;

    @FXML
    private Button changeFixedOdds;

    @FXML
    private Button changeRoot;

    @FXML
    private Button create;

    @FXML
    private Button exit;

    @FXML
    private Button showWithFixedOdds;

    @FXML
    private Button showWithRoots;

    @FXML
    void initialize() {
        create.setOnAction(event -> openCreatePolinomWindow());
        changeFixedOdds.setOnAction(event -> openChangeFixedOddsWindow());
        changeRoot.setOnAction(event -> openChangeRootWindow());
        calculate.setOnAction(event -> openCalculateWindow());
        showWithFixedOdds.setOnAction(event -> showPolinomWithFixedOdds());
        showWithRoots.setOnAction(event->showPolinomWithRoots());
        exit.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Завершение работы");
            alert.setHeaderText("Программа была завершена");
            alert.showAndWait();
            Platform.exit();
            System.exit(0);
        });


    }

    private void openCreatePolinomWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/create-polinom.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) create.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openCalculateWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/calculate.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) calculate.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void openChangeFixedOddsWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/changeMaxOdd.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) changeFixedOdds.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openChangeRootWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/changeRoot.fxml"));

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) changeRoot.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showPolinomWithFixedOdds(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Вывод полинома");
        alert.setHeaderText("Полином");
        alert.setContentText(Menu.polinom.showWithFixedOdds());
        alert.showAndWait();
    }

    private void showPolinomWithRoots(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Вывод полинома");
        alert.setHeaderText("");
        alert.setContentText(Menu.polinom.showWithRoots());
        alert.showAndWait();
    }



}

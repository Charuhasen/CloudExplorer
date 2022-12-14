package com.mycompany.cloudexplorer;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryController {
    
    @FXML
    private TextField userNameRegister;
    
    @FXML
    private PasswordField passwordRegister;
    
    @FXML
    private PasswordField passwordRegisterReEntry;
    
    @FXML
    private Button registerButton;
    
    @FXML
    private Label statusLabel;
    
    @FXML
    private void registerBtnHandler(ActionEvent event) {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) registerButton.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            userDB myObj = new userDB();
            if (passwordRegister.getText().equals(passwordRegisterReEntry.getText())) {
                myObj.addDataToDB(userNameRegister.getText(), passwordRegister.getText());
                dialogue("Adding information to the database", "Successful!");
                String[] credentials = {userNameRegister.getText(), passwordRegister.getText()};
                statusLabel.setText("SUCCESS!");
//                statusLabel.setTextFill(Color.color(0, 255, 0));
//                loader.setLocation(getClass().getResource("secondary.fxml"));
//                Parent root = loader.load();
//                Scene scene = new Scene(root, 640, 480);
//                secondaryStage.setScene(scene);
//                SecondaryController controller = loader.getController();
//                secondaryStage.setTitle("Show users");
//                controller.initialise(credentials);
//                String msg = "some data sent from Register Controller";
//                secondaryStage.setUserData(msg);
            } else {
                loader.setLocation(getClass().getResource("register.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 640, 480);
                secondaryStage.setScene(scene);
                secondaryStage.setTitle("Register a new User");
            }
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void dialogue(String headerMsg, String contentMsg) {
    Stage secondaryStage = new Stage();
    Group root = new Group();
    Scene scene = new Scene(root, 300, 300, Color.DARKGRAY);
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Dialog");
    alert.setHeaderText(headerMsg);
    alert.setContentText(contentMsg);
    Optional<ButtonType> result = alert.showAndWait();
    }

}

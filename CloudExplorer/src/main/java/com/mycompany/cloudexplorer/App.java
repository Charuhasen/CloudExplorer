package com.mycompany.cloudexplorer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Stage secondaryStage = new Stage();
        
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("primary.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 580);
            secondaryStage.setResizable(false);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Cloud Explorer");
            secondaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}
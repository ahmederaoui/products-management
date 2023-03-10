package ma.enset.tpjdbc.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Application1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane root = FXMLLoader.load(getClass().getResource("views/main.fxml"));
        Scene scene=new Scene(root,600,600);
        primaryStage.setTitle("Gestion des Commandes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

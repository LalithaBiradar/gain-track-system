
package com.gymmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        loadLoginScene();
    }

    public static void loadLoginScene() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/login.fxml"));
        primaryStage.setTitle("GymTrack - Login");
        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(Main.class.getResource("/css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void loadDashboard(String role) throws IOException {
        String fxmlPath = switch (role.toLowerCase()) {
            case "admin" -> "/fxml/admin/dashboard.fxml";
            case "member" -> "/fxml/member/dashboard.fxml";
            case "trainer" -> "/fxml/trainer/dashboard.fxml";
            default -> throw new IllegalArgumentException("Invalid role: " + role);
        };

        Parent root = FXMLLoader.load(Main.class.getResource(fxmlPath));
        primaryStage.setTitle("GymTrack - " + role.substring(0, 1).toUpperCase() + role.substring(1) + " Dashboard");
        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(Main.class.getResource("/css/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

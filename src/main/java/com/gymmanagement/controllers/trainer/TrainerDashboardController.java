
package com.gymmanagement.controllers.trainer;

import com.gymmanagement.Main;
import com.gymmanagement.utils.SessionManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TrainerDashboardController implements Initializable {

    @FXML
    private Label welcomeLabel;
    
    @FXML
    private Label totalClientsLabel;
    
    @FXML
    private Label scheduledSessionsLabel;
    
    @FXML
    private Label monthlyEarningsLabel;
    
    @FXML
    private Label ratingLabel;
    
    @FXML
    private HBox dashboardNav;
    
    @FXML
    private HBox clientsNav;
    
    @FXML
    private HBox scheduleNav;
    
    @FXML
    private HBox workoutPlansNav;
    
    @FXML
    private HBox profileNav;
    
    @FXML
    private Button logoutButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Check if user is logged in and has trainer role
        if (!SessionManager.isLoggedIn() || !SessionManager.hasRole("trainer")) {
            handleLogout();
            return;
        }
        
        // Set welcome message
        if (SessionManager.getCurrentUser() != null) {
            welcomeLabel.setText("Welcome, " + SessionManager.getCurrentUser().getUsername());
        }
        
        // Set mock data
        totalClientsLabel.setText("14");
        scheduledSessionsLabel.setText("28");
        monthlyEarningsLabel.setText("$2,450");
        ratingLabel.setText("4.8");
        
        // Setup navigation
        setupNavigation();
    }
    
    private void setupNavigation() {
        dashboardNav.setOnMouseClicked(event -> loadModule("dashboard"));
        clientsNav.setOnMouseClicked(event -> loadModule("clients"));
        scheduleNav.setOnMouseClicked(event -> loadModule("schedule"));
        workoutPlansNav.setOnMouseClicked(event -> loadModule("workout-plans"));
        profileNav.setOnMouseClicked(event -> loadModule("profile"));
        
        logoutButton.setOnAction(event -> handleLogout());
    }
    
    private void loadModule(String module) {
        // This would load different modules/views, but for now we'll just print to console
        System.out.println("Loading trainer module: " + module);
        // TODO: Implement module navigation
    }
    
    private void handleLogout() {
        // Clear session and return to login
        SessionManager.logout();
        try {
            Main.loadLoginScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

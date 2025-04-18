
package com.gymmanagement.controllers.admin;

import com.gymmanagement.Main;
import com.gymmanagement.dao.UserDAO;
import com.gymmanagement.models.User;
import com.gymmanagement.utils.SessionManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    private Label welcomeLabel;
    
    @FXML
    private Label totalMembersLabel;
    
    @FXML
    private Label totalTrainersLabel;
    
    @FXML
    private Label activeUsersLabel;
    
    @FXML
    private Label revenueLabel;
    
    @FXML
    private VBox membersNav;
    
    @FXML
    private VBox trainersNav;
    
    @FXML
    private VBox paymentsNav;
    
    @FXML
    private VBox workoutPlansNav;
    
    @FXML
    private VBox reportsNav;
    
    @FXML
    private VBox settingsNav;
    
    @FXML
    private Button logoutButton;

    private UserDAO userDAO = new UserDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Check if user is logged in and has admin role
        if (!SessionManager.isLoggedIn() || !SessionManager.hasRole("admin")) {
            handleLogout();
            return;
        }
        
        // Set welcome message
        User currentUser = SessionManager.getCurrentUser();
        if (currentUser != null) {
            welcomeLabel.setText("Welcome, " + currentUser.getUsername());
        }
        
        // Set dashboard statistics (mock data for now)
        totalMembersLabel.setText("253");
        totalTrainersLabel.setText("14");
        activeUsersLabel.setText("189");
        revenueLabel.setText("$32,450");
        
        // Setup navigation events
        setupNavigation();
    }
    
    private void setupNavigation() {
        membersNav.setOnMouseClicked(event -> loadModule("members"));
        trainersNav.setOnMouseClicked(event -> loadModule("trainers"));
        paymentsNav.setOnMouseClicked(event -> loadModule("payments"));
        workoutPlansNav.setOnMouseClicked(event -> loadModule("workout-plans"));
        reportsNav.setOnMouseClicked(event -> loadModule("reports"));
        settingsNav.setOnMouseClicked(event -> loadModule("settings"));
        
        logoutButton.setOnAction(event -> handleLogout());
    }
    
    private void loadModule(String module) {
        // This would load different modules/views, but for now we'll just print to console
        System.out.println("Loading module: " + module);
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

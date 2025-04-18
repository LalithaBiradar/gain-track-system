
package com.gymmanagement.controllers.member;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MemberDashboardController implements Initializable {

    @FXML
    private Label welcomeLabel;
    
    @FXML
    private Label membershipLabel;
    
    @FXML
    private Label expiryDateLabel;
    
    @FXML
    private Label upcomingSessionsLabel;
    
    @FXML
    private Label bodyweightLabel;
    
    @FXML
    private HBox dashboardNav;
    
    @FXML
    private HBox workoutPlansNav;
    
    @FXML
    private HBox progressNav;
    
    @FXML
    private HBox paymentsNav;
    
    @FXML
    private HBox profileNav;
    
    @FXML
    private Button logoutButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Check if user is logged in and has member role
        if (!SessionManager.isLoggedIn() || !SessionManager.hasRole("member")) {
            handleLogout();
            return;
        }
        
        // Set welcome message
        if (SessionManager.getCurrentUser() != null) {
            welcomeLabel.setText("Welcome, " + SessionManager.getCurrentUser().getUsername());
        }
        
        // Set mock data
        membershipLabel.setText("Premium Plan");
        
        // Set expiry date (3 months from now)
        LocalDate expiryDate = LocalDate.now().plusMonths(3);
        expiryDateLabel.setText(expiryDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        
        upcomingSessionsLabel.setText("2");
        bodyweightLabel.setText("75 kg");
        
        // Setup navigation
        setupNavigation();
    }
    
    private void setupNavigation() {
        dashboardNav.setOnMouseClicked(event -> loadModule("dashboard"));
        workoutPlansNav.setOnMouseClicked(event -> loadModule("workout-plans"));
        progressNav.setOnMouseClicked(event -> loadModule("progress"));
        paymentsNav.setOnMouseClicked(event -> loadModule("payments"));
        profileNav.setOnMouseClicked(event -> loadModule("profile"));
        
        logoutButton.setOnAction(event -> handleLogout());
    }
    
    private void loadModule(String module) {
        // This would load different modules/views, but for now we'll just print to console
        System.out.println("Loading member module: " + module);
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

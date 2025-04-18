
package com.gymmanagement.controllers;

import com.gymmanagement.Main;
import com.gymmanagement.dao.UserDAO;
import com.gymmanagement.models.User;
import com.gymmanagement.utils.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Label errorLabel;

    private UserDAO userDAO = new UserDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Clear any error messages
        errorLabel.setText("");
        
        // Add enter key event handler
        passwordField.setOnKeyPressed(this::handleEnterKey);
    }

    @FXML
    private void handleLoginButton(ActionEvent event) {
        attemptLogin();
    }
    
    private void handleEnterKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            attemptLogin();
        }
    }
    
    private void attemptLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        
        // Validate input
        if (username.isEmpty() || password.isEmpty()) {
            showError("Username and password are required.");
            return;
        }
        
        // Attempt authentication
        User user = userDAO.authenticate(username, password);
        
        if (user != null) {
            // Success - store in session and navigate to appropriate dashboard
            SessionManager.login(user, user.getRole());
            navigateToDashboard(user.getRole());
        } else {
            // Authentication failed
            showError("Invalid username or password. Please try again.");
            passwordField.clear();
        }
    }
    
    private void showError(String message) {
        errorLabel.setText(message);
    }
    
    private void navigateToDashboard(String role) {
        try {
            Main.loadDashboard(role);
        } catch (IOException e) {
            e.printStackTrace();
            showError("Error loading dashboard: " + e.getMessage());
        }
    }
}

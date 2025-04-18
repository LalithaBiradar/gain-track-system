
package com.gymmanagement.dao;

import com.gymmanagement.models.User;
import com.gymmanagement.utils.DatabaseConnector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    
    // For demonstration purposes, we'll use a mock database with predefined users
    private static final List<User> mockUsers = new ArrayList<>();
    
    static {
        // Initialize with some mock users
        mockUsers.add(new User(1, "admin", "admin123", "admin@gym.com", "admin", LocalDateTime.now(), true));
        mockUsers.add(new User(2, "member1", "member123", "member1@gmail.com", "member", LocalDateTime.now(), true));
        mockUsers.add(new User(3, "trainer1", "trainer123", "trainer1@gym.com", "trainer", LocalDateTime.now(), true));
    }
    
    public User authenticate(String username, String password) {
        // Mock authentication - in a real app, you'd check against password hash
        for (User user : mockUsers) {
            if (user.getUsername().equals(username) && user.getPasswordHash().equals(password) && user.isActive()) {
                // Update last login time
                user.setLastLogin(LocalDateTime.now());
                return user;
            }
        }
        return null;
    }
    
    // The methods below would normally use database connections, but for demonstration
    // we're using the mock list
    
    public List<User> getAllUsers() {
        return new ArrayList<>(mockUsers);
    }
    
    public User getUserById(int id) {
        for (User user : mockUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public User getUserByUsername(String username) {
        for (User user : mockUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    public List<User> getUsersByRole(String role) {
        List<User> users = new ArrayList<>();
        for (User user : mockUsers) {
            if (user.getRole().equals(role)) {
                users.add(user);
            }
        }
        return users;
    }
    
    public boolean addUser(User user) {
        // Generate a new ID
        int newId = mockUsers.isEmpty() ? 1 : mockUsers.get(mockUsers.size() - 1).getId() + 1;
        user.setId(newId);
        return mockUsers.add(user);
    }
    
    public boolean updateUser(User user) {
        for (int i = 0; i < mockUsers.size(); i++) {
            if (mockUsers.get(i).getId() == user.getId()) {
                mockUsers.set(i, user);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteUser(int id) {
        return mockUsers.removeIf(user -> user.getId() == id);
    }
    
    // This method demonstrates what the real database implementation would look like
    public List<User> getAllUsersFromDB() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                user.setLastLogin(rs.getTimestamp("last_login").toLocalDateTime());
                user.setActive(rs.getBoolean("active"));
                users.add(user);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error getting users from database: " + e.getMessage());
        }
        
        return users;
    }
}

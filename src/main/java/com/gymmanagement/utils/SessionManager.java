
package com.gymmanagement.utils;

import com.gymmanagement.models.User;

public class SessionManager {
    private static User currentUser;
    private static String userRole;

    public static void login(User user, String role) {
        currentUser = user;
        userRole = role.toLowerCase();
    }

    public static void logout() {
        currentUser = null;
        userRole = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static String getUserRole() {
        return userRole;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static boolean hasRole(String role) {
        return isLoggedIn() && userRole.equalsIgnoreCase(role);
    }
}

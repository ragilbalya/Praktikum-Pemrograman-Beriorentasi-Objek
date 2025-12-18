package studi_kasus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoginTracker {
    private Set<String> activeUsers = new HashSet<>();
    private Map<String, Integer> loginAttempts = new HashMap<>();

    public void loginAttempt(String username, boolean success) {
        loginAttempts.put(username, loginAttempts.getOrDefault(username, 0) + 1);
        if (success) activeUsers.add(username);
    }

    public void logout(String username) {
        activeUsers.remove(username);
    }

    public boolean isActive(String username) {
        return activeUsers.contains(username);
    }

    public int getAttempts(String username) {
        return loginAttempts.getOrDefault(username, 0);
    }
}